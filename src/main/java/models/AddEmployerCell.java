package models;

import java.io.IOException;

import Views.AllEmployersViewController;
import conexion.Employer;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddEmployerCell extends ItemEmployerCell{
	
	public AddEmployerCell(ListView<Employer> list, AllEmployersViewController cont)
	{
		super();
		RestMain client = RestMain.getInstance();
		showEmployers = cont;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ItemEmployerCell.class.getResource("/Views/EmployerCell.fxml"));
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
