package Views;

import java.util.ArrayList;

import conexion.Employer;
import conexion.Person;
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
import models.ItemEmployerCell;
import models.Text;
import models.ViewTransitionalModel;

public class AllEmployersViewController {
	
	ViewTransitionalModel vm;
	ListEmployer listEmployer;
	Employer employer;
	Text info;
	
	public Text getInfo() {
		return info;
	}



	public void setInfo(Text info) {
		this.info = info;
	}
	
	public Employer getEmployer() {
		return employer;
	}



	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	public void setEmployerName() {
		employerTitle.textProperty().bind(this.info.getEmployerName());
		this.info.getEmployerName().set(employer.getUserName());
	}
	
	public void setEmployerDescriptionName() {
		employerDescriptionLabel.textProperty().bind(this.info.getEmployerDescription());
		this.info.getEmployerDescription().set(employer.getUserBio());
	}
	
	public void setEmployerViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
//		this.employer = (Employer) vm.getLoggedIn();
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
	
    @FXML
    private Label employerDescriptionLabel;


    @FXML
    private Label employerTitle;
	
	public void showEmployerItem(Employer item) {
		vm.showSingleEmployer(item.getPageID());
	}
	
	private final AllEmployersViewController itemShower;
	
    public AllEmployersViewController()
    {
    	itemShower=this;
//    	loggedIn = null;
    }
    
    public void setEmployerModel(ListEmployer model)
    {
    	this.listEmployer = model;
    	
    	allEmployersList.setCellFactory(new Callback<ListView<Employer>, ListCell<Employer>>()
		  {

			@Override
			public ListCell<Employer> call(ListView<Employer> lv)
			{
				return new ItemEmployerCell(lv,itemShower);
			}
		  });
    	
    	allEmployersList.setItems(model.getItems());
    	
    	
    }
    

    @FXML
    private Button relatedJobButton;

    @FXML
    private Button relatedPersonButton;

    @FXML
    private Button relatedPostButton;

    @FXML
    private Button relatedSkillButton;

    @FXML
    void onClickRelatedJob(ActionEvent event) {
    	vm.showAllJobs(employer);
    }

    @FXML
    void onClickRelatedPerson(ActionEvent event) {
    	vm.showAllPersons(employer);
    }

    @FXML
    void onClickRelatedPost(ActionEvent event) {
    	vm.showAllPosts(employer);
    }

    @FXML
    void onClickRelatedSkill(ActionEvent event) {
    	vm.showAllSkills(employer);
    }
	
	//Edit Skill
//
//    @FXML
//    private Button EditSave;
//
//    @FXML
//    private TextField skillNameTextField;
//
//    @FXML
//    void onClickSkillEditSave(ActionEvent event) {
////    	setEditInfo();
//    	String skillName = skillNameTextField.textProperty().get();
//    	
//    	skill.setSkillName(skillName);
//    	RestMain client = RestMain.getInstance();
//    	client.updatePage(skill);
//    	vm.showSingleSkill(skill.getPageID());
//    	
//    }
}
