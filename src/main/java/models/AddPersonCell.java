package models;

import java.io.IOException;

import Views.AllPersonsViewController;
import conexion.Person;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddPersonCell extends ItemPersonCell{
	
	public AddPersonCell(ListView<Person> list, AllPersonsViewController cont)
	{
		super();
		RestMain client = RestMain.getInstance();
		showPersons = cont;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ItemPersonCell.class.getResource("/Views/addPersonCell.fxml"));
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
