package models;

import java.io.IOException;

import Views.AllJobsViewController;
import conexion.Job;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddJobCell extends ItemJobCell{
	
	public AddJobCell(ListView<Job> list, AllJobsViewController cont)
	{
		super();
		RestMain client = RestMain.getInstance();
		showJobs = cont;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ItemJobCell.class.getResource("/Views/jobCell.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      itemController = loader.getController(); //store for later
	      itemController.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
		
		
	}
	
	
}
