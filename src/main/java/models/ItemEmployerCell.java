package models;

import java.io.IOException;

import Views.AllEmployersViewController;
import Views.EmployerCellController;
import conexion.Employer;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ItemEmployerCell extends ListCell<Employer> {
	AllEmployersViewController showEmployers; 
	EmployerCellController itemController;
	Node node;

		
		public ItemEmployerCell(ListView<Employer> list, AllEmployersViewController cont)
		{
			RestMain client = RestMain.getInstance();
			showEmployers = cont;
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ItemEmployerCell.class.getResource("/Views/employerCell.fxml"));
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
		protected void updateItem(Employer item, boolean empty)
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
			showEmployers.showEmployerItem(getItem());
		}
		

		
	}


