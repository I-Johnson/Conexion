package Views;

import java.util.ArrayList;
import models.AddPersonCell;
import conexion.Page;
import conexion.Person;
import conexion.RestMain;
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
import models.ItemPersonCell;
import models.Text;
import models.ViewTransitionalModel;

public class AllPersonsViewController {
	
	ViewTransitionalModel vm;
	ListPerson listPerson;
	Person person;
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
	
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setPersonName() {
		personTitle.textProperty().bind(this.info.getPersonName());
		this.info.getPersonName().set(person.getUserName());
	}
	
	public void setPersonDescriptionName() {
		personDescriptionLabel.textProperty().bind(this.info.getPersonDescription());
		this.info.getPersonDescription().set(person.getUserBio());
	}
	
	public void setEditInfo() {
		personNameTextField.textProperty().set(person.getUserName());
		personDescriptionTextField.textProperty().set(person.getUserBio());
	}
	
	public void setPersonViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	
	
    @FXML
    private ListView<Person> allPersonsList;
    
	@FXML 
	private Button myPersonsButton;
	

	@FXML
	void onClickShowOnlyMyPersons(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Person> myPersons = new ArrayList<Person> ();
			for (Person person: allPersonsList.getItems()) {
				if (vm.getLoggedIn().getPersons().contains(person.getPageID())) {
					myPersons.add(person);
				}
			}
			ObservableList<Person> myObservablePerson = FXCollections.observableList(myPersons);
			allPersonsList.setItems(myObservablePerson);
		}
	}
	
    @FXML
    private Label personDescriptionLabel;


    @FXML
    private Label personTitle;


	
	public void showPersonItem(Person item) {
		vm.showSinglePerson(item.getPageID());
	}
	
	private final AllPersonsViewController itemShower;
	
    public AllPersonsViewController()
    {
    	itemShower=this;
//    	loggedIn = null;
    }
    
    public void setPersonModel(ListPerson model)
    {
    	this.listPerson = model;
    	
    	allPersonsList.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>()
		  {

			@Override
			public ListCell<Person> call(ListView<Person> lv)
			{
				return new ItemPersonCell(lv,itemShower);
			}
		  });
    	
    	allPersonsList.setItems(model.getItems());
    	
    	
    }
    
    public void setAddPersonModel(ListPerson model)
    {
    	this.listPerson = model;
    	
    	allPersonsList.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>()
		  {

			@Override
			public ListCell<Person> call(ListView<Person> lv)
			{
				AddPersonCell addPersonCell =  new AddPersonCell(lv,itemShower);
				addPersonCell.getItemController().setParent(parent);
				return addPersonCell;
			}
		  });
    	
    	allPersonsList.setItems(model.getItems());
    	
    	
    }
    
    
    
    

    @FXML
    private Button relatedEmployer;

    @FXML
    private Button relatedJob;

    @FXML
    private Button relatedPosts;

    @FXML
    private Button relatedSkill;

    @FXML
    void onClickRelatedEmployer(ActionEvent event) {
    	vm.showAllEmployers(person);
    }

    @FXML
    void onClickRelatedJobs(ActionEvent event) {
    	vm.showAllJobs(person);
    }

    @FXML
    void onClickRelatedPosts(ActionEvent event) {
    	vm.showAllPosts(person);
    }

    @FXML
    void onClickRelatedSkills(ActionEvent event) {
    	vm.showAllSkills(person);
    }
	
    @FXML
    private TextArea personDescriptionTextField;

    @FXML
    private Button personEditSave;

    @FXML
    private TextField personNameTextField;

    @FXML
    void onClickPersonEditSave(ActionEvent event) {
//    	setEditInfo();
    	String personName = personNameTextField.textProperty().get();
    	String personDescription = personDescriptionTextField.textProperty().get();
    	
    	person.setUserName(personName);
    	person.setUserBio(personDescription);
    	RestMain client = RestMain.getInstance();
    	client.updatePage(person);
    	vm.showSinglePerson(person.getPageID());
  	
    }
    
    @FXML
    private Button signOut;
    @FXML
    void onClickSignOut(ActionEvent event) {
    	vm.setLoggedIn(null);
    	vm.changetoLoginView();

    }
    

    @FXML
    private Button personEditButton;
    
//    @FXML
//    private Label personDescriptionLabel;
//
//    @FXML
//    private Label personTitle;
    
    @FXML
    void onClickEditPersonPage(ActionEvent event) {
    	
    	if (person.has_permission(vm.getLoggedIn())) {
    		vm.showEditPerson(person.getPageID());
    	}
    }
    @FXML
    private Button addEmployer;

    @FXML
    private Button addSkill;

    @FXML
    private Button addJob;

    @FXML
    private Button addPosts;
    @FXML
    void onClickAddEmployer(ActionEvent event) {
    	vm.showAddEmployers();;
    }

    @FXML
    void onClickAddJobs(ActionEvent event) {
    	vm.showAddJobs();
    }

    @FXML
    void onClickAddSkills(ActionEvent event) {
    	vm.showAddSkills();
    }

    @FXML
    void onClickAddPosts(ActionEvent event) {
    	vm.showAddPosts();
    }

    
}
