package models;

import java.io.IOException;

import Views.AllJobsViewController;
import Views.JobCellController;
import conexion.Job;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ItemJobCell extends ListCell<Job> {
	AllJobsViewController showJobs; 
	JobCellController itemController;
	Node node;

		
		public ItemJobCell(ListView<Job> list, AllJobsViewController cont)
		{
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


		@Override
		protected void updateItem(Job item, boolean empty)
		{
			if(!empty)
			{
				itemController.updateView(item);
			}
			else
			{
				itemController.updateView(null);
			}
			super.updateItem(item, empty);
		}

		
		public void showItem()
		{
			showJobs.showJobItem(getItem());
		}
		

		
	}


