package Views;

import java.util.ArrayList;

import conexion.Job;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.ViewTransitionalModel;

public class AllJobsViewController
{
	ViewTransitionalModel vm;
	public void setModel(ViewTransitionalModel vm) {
		this.vm = vm;
		RestMain client = RestMain.getInstance();
		ObservableList<Job> observableJobs = FXCollections.observableList(client.getAllJobs());
		allJobsList.setItems(observableJobs);
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
	
}
