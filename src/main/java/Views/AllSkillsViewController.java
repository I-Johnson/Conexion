package Views;
import java.util.ArrayList;

import conexion.RestMain;
import conexion.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import models.ItemSkillCell;
import models.Text;
import models.ViewTransitionalModel;

public class AllSkillsViewController {
	ViewTransitionalModel vm;
	ListSkill listSkill;
	Skill skill;
	Text info;
	
	
	public Text getInfo() {
		return info;
	}



	public void setInfo(Text info) {
		this.info = info;
	}
	
	public Skill getSkill() {
		return skill;
	}



	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	public void setSkillName() {
		skillTitle.textProperty().bind(this.info.getSkillName());
		this.info.getSkillName().set(skill.getSkillName());
	}
	
	
	public void setEditInfo() {
		skillNameTextField.textProperty().set(skill.getSkillName());
	}
	
	public void setSkillViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	
    @FXML
    private ListView<Skill> allSkillsList;
    
    @FXML 
	private Button mySkillsButton;
    
	public void showSkillItem(Skill item) {
		vm.showSingleSkill(item.getPageID());
	}
	
	
//    @FXML
//    private Label skillDescriptionLabel;

    @FXML
    private Button skillEditButton;

    @FXML
    private Label skillTitle;

    @FXML
    void onClickEditSkillPage(ActionEvent event) {
//    	String user = loggedIn.getPageID();
//    	if (job.has_permission(loggedIn)) {
//    		vm.showEditJob(job.getPageID());
//    	}
//    	if (job.getEditors().contains(user)) {
//            vm.showEditJob(job.getPageID());
//        }
//    	System.out.print("print" + user);
    	vm.showEditSkill(skill.getPageID());
    	
    }
	
	@FXML
	void onClickShowOnlyMySkills(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Skill> mySkills = new ArrayList<Skill> ();
			for (Skill skill: allSkillsList.getItems()) {
				if (vm.getLoggedIn().getSkills().contains(skill.getPageID())) {
					mySkills.add(skill);
				}
			}
			ObservableList<Skill> myObservableSkills = FXCollections.observableList(mySkills);
			allSkillsList.setItems(myObservableSkills);
		}
	}
	
	private final AllSkillsViewController itemShower;
	
    public AllSkillsViewController()
    {
    	itemShower=this;
//    	loggedIn = null;
    }
    
    public void setSkillModel(ListSkill model)
    {
    	this.listSkill= model;
    	
    	allSkillsList.setCellFactory(new Callback<ListView<Skill>, ListCell<Skill>>()
		  {

			@Override
			public ListCell<Skill> call(ListView<Skill> lv)
			{
				return new ItemSkillCell(lv,itemShower);
			}
		  });
    	
    	allSkillsList.setItems(model.getItems());
    	
    	
    }
	
	//Edit Skill

    @FXML
    private Button skillEditSave;

    @FXML
    private TextField skillNameTextField;

    @FXML
    void onClickSkillEditSave(ActionEvent event) {
//    	setEditInfo();
    	String skillName = skillNameTextField.textProperty().get();
    	
    	skill.setSkillName(skillName);
    	RestMain client = RestMain.getInstance();
    	client.updatePage(skill);
    	vm.showSingleSkill(skill.getPageID());
    	
    }
    
    @FXML
    private Button relatedEmployer;

    @FXML
    private Button relatedJobs;

    @FXML
    private Button relatedPerson;

    @FXML
    private Button relatedPosts;

 

    @FXML
    void onClickPerson(ActionEvent event) {
    	vm.showAllPersons(skill);
    }

    @FXML
    void onClickRelatedEmployer(ActionEvent event) {
    	vm.showAllEmployers(skill);
    }

    @FXML
    void onClickRelatedJob(ActionEvent event) {
    	vm.showAllJobs(skill);
    }

    @FXML
    void onClickRelatedPosts(ActionEvent event) {
    	vm.showAllPosts(skill);
    }
}
