package Views;
import java.util.ArrayList;

import conexion.RestMain;
import conexion.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.ViewTransitionalModel;

public class AllSkillsViewController {
	ViewTransitionalModel vm;
	public void setModel(ViewTransitionalModel vm) {
		this.vm = vm;
		RestMain client = RestMain.getInstance();
		ObservableList<Skill> observableSkills = FXCollections.observableList(client.getAllSkills());
		allSkillsList.setItems(observableSkills);
	}
    @FXML
    private ListView<Skill> allSkillsList;
    
    @FXML 
	private Button mySkillsButton;
	
	@FXML
	void onClickShowOnlyMySkills(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Skill> mySkills = new ArrayList<Skill> ();
			for (Skill skill: allSkillsList.getItems()) {
				if (vm.getLoggedIn().getSkills().contains(skill.getPageID())) {
					mySkills.add(skill);
				}
			}
			ObservableList<Skill> myObservableJobs = FXCollections.observableList(mySkills);
			allSkillsList.setItems(myObservableJobs);
		}
	}
}
