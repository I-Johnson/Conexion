package Views;

import java.util.ArrayList;

import conexion.Employer;
import conexion.Page;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import models.AddEmployerCell;
import models.AddSkillCell;
import models.ItemEmployerCell;
import models.ItemSkillCell;
import models.Text;
import models.ViewTransitionalModel;

public class AllEmployersViewController {
	
	ViewTransitionalModel vm;
	ListEmployer listEmployer;
	Employer employer;
	Text info;
	Page parent;
	
	
	
	public Page getParent() {
		return parent;
	}



	public void setParent(Page parent) {
		this.parent = parent;
	}



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
	
	
	public void setEmployerViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
//		this.employer = (Employer) vm.getLoggedIn();
	}
	
	
    @FXML
    private ListView<Employer> allEmployersList;
    
	@FXML 
	private Button myEmployerButton;

	
	
	public void setEmployerName() {
		employerTitle.textProperty().bind(this.info.getEmployerName());
		this.info.getEmployerName().set(employer.getUserName());
	}
	
	public void setEmployerDescriptionName() {
		employerDescriptionLabel.textProperty().bind(this.info.getEmployerDescription());
		this.info.getEmployerDescription().set(employer.getUserBio());
	}
	
	public void setEditInfo() {
		employerNameTextField.textProperty().set(employer.getUserName());
		employerDescriptionTextField.textProperty().set(employer.getUserBio());
	}
	
	public void showEmployerItem(Employer item) {
		vm.showSingleEmployer(item.getPageID());
	}
	
	private final AllEmployersViewController itemShower;
	
    public AllEmployersViewController()
    {
    	itemShower=this;
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
    
    public void setAddEmployerModel(ListEmployer model)
    {
    	this.listEmployer = model;
    	
    	allEmployersList.setCellFactory(new Callback<ListView<Employer>, ListCell<Employer>>()
		  {

			@Override
			public ListCell<Employer> call(ListView<Employer> lv)
			{
				AddEmployerCell addEmployerCell = new AddEmployerCell(lv,itemShower);
				addEmployerCell.getItemController().setParent(parent);
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
	
    @FXML
    private TextArea employerDescriptionTextField;

    @FXML
    private Button employerEditSave;

    @FXML
    private TextField employerNameTextField;

    @FXML
    void onClickEmployerEditSave(ActionEvent event) {
//    	setEditInfo();
    	String employerName = employerNameTextField.textProperty().get();
    	String employerDescription = employerDescriptionTextField.textProperty().get();
    	
    	employer.setUserName(employerName);
    	employer.setUserBio(employerDescription);
    	RestMain client = RestMain.getInstance();
    	client.updatePage(employer);
    	vm.showSingleEmployer(employer.getPageID());
    	
    }
//    
    @FXML
    private Label employerDescriptionLabel;

    @FXML
    private Button employerEditButton;

    @FXML
    private Label employerTitle;

    @FXML
    void onClickEditEmployerPage(ActionEvent event) {

    	
    	if (employer.has_permission(vm.getLoggedIn())) {
    		vm.showEditEmployer(employer.getPageID());
    	}
    }
    
    @FXML
    private Button signOut;
    @FXML
    void onClickSignOut(ActionEvent event) {
    	vm.setLoggedIn(null);
    	vm.changetoLoginView();

    }
    
    @FXML
    private Button addSkillButton;

    @FXML
    private Button addJobButton;

    @FXML
    private Button addPersonButton;

    @FXML
    private Button addPostButton;
    
    @FXML
    void onClickAddJob(ActionEvent event) {
    	vm.showAddJobs();
    }

    @FXML
    void onClickAddSkill(ActionEvent event) {
    	vm.showAddSkills();
    }

    @FXML
    void onClickAddPerson(ActionEvent event) {
    	vm.showAddPerson();
    }

    @FXML
    void onClickAddPost(ActionEvent event) {
    	vm.showAddPosts();
    }
}
