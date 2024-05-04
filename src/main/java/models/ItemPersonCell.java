package models;

import java.io.IOException;

import Views.AllPersonsViewController;
import Views.PersonCellController;
import conexion.Person;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ItemPersonCell extends ListCell<Person> {
	AllPersonsViewController showPersons; 
	PersonCellController itemController;
	Node node;

		
		public ItemPersonCell(ListView<Person> list, AllPersonsViewController cont)
		{
			RestMain client = RestMain.getInstance();
			showPersons = cont;
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ItemPersonCell.class.getResource("/Views/personCell.fxml"));
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
		protected void updateItem(Person item, boolean empty)
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
			showPersons.showPersonItem(getItem());
		}
		

		
	}


