package Views;

import java.util.ArrayList;

import conexion.Job;
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
import models.ItemJobCell;
import models.Text;

public class AllJobsViewController
{
	ViewTransitionalModel vm;
	ListJob listJob;
	Job job;
	Text info;
	User loggedIn;
	
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
	void onClickShowOnlyMyJobs(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Job> myJobs = new ArrayList<Job> ();
			for (Job job: allJobsList.getItems()) {
				if (vm.getLoggedIn().getJobs().contains(job.getPageID())) {
					myJobs.add(job);
				}
			}
			ObservableList<Job> myObservableJobs = FXCollections.observableList(myJobs);
			allJobsList.setItems(myObservableJobs);
		}
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
		// TODO Auto-generated method stub
		//replace w/ changetoSingleJob
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
	    

	    @FXML
	    private Label jobDescriptionLabel;

	    @FXML
	    private Button jobEditButton;

	    @FXML
	    private Label jobTitle;

	    @FXML
	    void onClickEditJobPage(ActionEvent event) {
//	    	String user = loggedIn.getPageID();
//	    	if (job.has_permission(loggedIn)) {
//	    		vm.showEditJob(job.getPageID());
//	    	}
//	    	if (job.getEditors().contains(user)) {
//	            vm.showEditJob(job.getPageID());
//	        }
//	    	System.out.print("print" + user);
	    	vm.showEditJob(job.getPageID());
	    	
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
	
}
