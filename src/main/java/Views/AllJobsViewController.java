package Views;

import java.util.ArrayList;

import conexion.Job;
import conexion.Page;
import conexion.RestMain;
import conexion.User;
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
import models.ViewTransitionalModel;
import models.AddJobCell;
import models.AddSkillCell;
import models.ItemJobCell;
import models.ItemSkillCell;
import models.Text;

public class AllJobsViewController
{
	ViewTransitionalModel vm;
	ListJob listJob;
	Job job;
	Text info;
	User loggedIn;
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



	public Job getJob() {
		return job;
	}



	public void setJob(Job job) {
		this.job = job;
	}



	public void setJobViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
	}
    

	@FXML
    private ListView<Job> allJobsList;
	
	@FXML 
	private Button myJobsButton;

	    @FXML
	    private Button relatedEmployerButton;

	    @FXML
	    private Button relatedPersonButton;

	    @FXML
	    private Button relatedPostButton;

	    @FXML
	    private Button relatedSkillButton;


	    @FXML
	    void onClickRelatedEmployerButton(ActionEvent event) {
	    	vm.showAllEmployers(job);
	    }

	    @FXML
	    void onClickRelatedPerson(ActionEvent event) {
	    	vm.showAllPersons(job);
	    }

	    @FXML
	    void onClickRelatedPostsButton(ActionEvent event) {
	    	vm.showAllPosts(job);
	    }

	    @FXML
	    void onClickRelatedSkill(ActionEvent event) {
	    	vm.showAllSkills(job);
	    }

	public void setJobName() {
		jobTitle.textProperty().bind(this.info.getJobName());
		this.info.getJobName().set(job.getPostTitle());
	}
	
	public void setJobDescriptionName() {
		jobDescriptionLabel.textProperty().bind(this.info.getJobDescription());
		this.info.getJobDescription().set(job.getPostBody());
	}
	
	public void setEditInfo() {
		jobNameTextField.textProperty().set(job.getPostTitle());
		jobDescriptionTextField.textProperty().set(job.getPostBody());
	}
	
	
	public void showJobItem(Job item) {
		vm.showSingleJob(item.getPageID());
		
	}

	
	 private final AllJobsViewController itemShower;
	    
	    
	    public AllJobsViewController()
	    {
	    	itemShower=this;
//	    	loggedIn = null;
	    }
	    
	    public void setJobModel(ListJob model)
	    {
	    	this.listJob = model;
	    	
	    	allJobsList.setCellFactory(new Callback<ListView<Job>, ListCell<Job>>()
			  {

				@Override
				public ListCell<Job> call(ListView<Job> lv)
				{
					return new ItemJobCell(lv,itemShower);
				}
			  });
	    	
	    	allJobsList.setItems(model.getItems());
	    }
	    
	    public void setAddJobModel(ListJob model)
	    {
	    	this.listJob = model;
	    	
	    	allJobsList.setCellFactory(new Callback<ListView<Job>, ListCell<Job>>()
			  {

				@Override
				public ListCell<Job> call(ListView<Job> lv)
				{
					AddJobCell addJobCell = new AddJobCell(lv,itemShower);
					addJobCell.getItemController().setParent(parent);
					return addJobCell;
				}
			  });
	    	
	    	allJobsList.setItems(model.getItems());
	    }
	    

	    @FXML
	    private Label jobDescriptionLabel;

	    @FXML
	    private Button jobEditButton;

	    @FXML
	    private Label jobTitle;

	    @FXML
	    void onClickEditJobPage(ActionEvent event) {
//	    	System.out.println(vm.getLoggedIn().getPageID());
//	    	System.out.print(job.getEditors());
	    	
	    	if (job.has_permission(vm.getLoggedIn())) {
	    		System.out.print("lkja");
	    		vm.showEditJob(job.getPageID());
	    	}
	    	
	    }
	    
	    //EditPage
	    @FXML
	    private TextArea jobDescriptionTextField;

	    @FXML
	    private Button jobEditSave;

	    @FXML
	    private TextField jobNameTextField;

	    @FXML
	    void onClickJobEditSave(ActionEvent event) {
//	    	setEditInfo();
	    	String jobName = jobNameTextField.textProperty().get();
	    	String jobDescription = jobDescriptionTextField.textProperty().get();
	    	
	    	job.setPostTitle(jobName);
	    	job.setPostBody(jobDescription);
	    	RestMain client = RestMain.getInstance();
	    	client.updatePage(job);
	    	vm.showSingleJob(job.getPageID());
	    	
	    }
	    
	    @FXML
	    private Button addEmployer;

	    @FXML
	    private Button addSkill;

	    @FXML
	    private Button addPerson;

	    @FXML
	    private Button addPost;
	    
	    @FXML
	    void onClickAddJobs(ActionEvent event) {
	    	vm.showAddJobs();
	    }
	    @FXML
	    void onClickAddEmployer(ActionEvent event) {
	    	vm.showAddEmployers();
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
	    void onClickAddPosts(ActionEvent event) {
	    	vm.showAddPosts();
	    }
	
}
