package models;

import java.io.IOException;

import Views.AllPersonsViewController;
import Views.AllSkillsViewController;
import conexion.Person;
import conexion.RestMain;
import conexion.Skill;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddSkillCell extends ItemSkillCell{
	
	public AddSkillCell(ListView<Skill> list, AllSkillsViewController cont)
	{
		super();
		RestMain client = RestMain.getInstance();
		showSkills = cont;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ItemSkillCell.class.getResource("/Views/addSkillCell.fxml"));
	    try {
	      node = loader.load(); 
	      
	      itemController = loader.getController(); 
	      itemController.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
		
		
	}
	
	
}
