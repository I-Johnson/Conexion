package Views;

import java.util.ArrayList;

import conexion.Employer;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.ViewTransitionalModel;

public class AllEmployersViewController {
	
	ViewTransitionalModel vm;
	public void setModel(ViewTransitionalModel vm) {
		this.vm = vm;
		RestMain client = RestMain.getInstance();
		ObservableList<Employer> observableEmployers = FXCollections.observableList(client.getAllEmployers());
		allEmployersList.setItems(observableEmployers);
	}
    @FXML
    private ListView<Employer> allEmployersList;
    
	@FXML 
	private Button myEmployerButton;
	
	@FXML
	void onClickShowOnlyMyEmployers(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Employer> myEmployer = new ArrayList<Employer> ();
			for (Employer employer: allEmployersList.getItems()) {
				if (vm.getLoggedIn().getEmployers().contains(employer.getPageID())) {
					myEmployer.add(employer);
				}
			}
			ObservableList<Employer> myObservableEmployers = FXCollections.observableList(myEmployer);
			allEmployersList.setItems(myObservableEmployers);
		}
	}
}
