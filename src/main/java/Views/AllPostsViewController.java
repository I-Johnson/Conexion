package Views;

import java.util.ArrayList;

import conexion.Post;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.ViewTransitionalModel;

public class AllPostsViewController
{
	ViewTransitionalModel vm;
	public void setModel(ViewTransitionalModel vm) {
		this.vm = vm;
		RestMain client = RestMain.getInstance();
		ObservableList<Post> observablePosts = FXCollections.observableList(client.getAllPosts());
		allPostsList.setItems(observablePosts);
	}
    

	@FXML
    private ListView<Post> allPostsList;
	
	@FXML 
	private Button myJobsButton;
	
	@FXML
	void onClickShowOnlyMyPosts(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Post> myJobs = new ArrayList<Post> ();
			for (Post post: allPostsList.getItems()) {
				if (vm.getLoggedIn().getJobs().contains(post.getPageID())) {
					myJobs.add(post);
				}
			}
			ObservableList<Post> myObservableJobs = FXCollections.observableList(myJobs);
			allPostsList.setItems(myObservableJobs);
		}
	}
	
}
