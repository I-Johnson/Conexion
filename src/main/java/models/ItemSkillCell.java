package models;

import java.io.IOException;

import Views.AllSkillsViewController;
import Views.SkillCellController;
import conexion.RestMain;
import conexion.Skill;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ItemSkillCell extends ListCell<Skill> {
	AllSkillsViewController showSkills; 
	SkillCellController itemController;
	Node node;

		
		public ItemSkillCell(ListView<Skill> list, AllSkillsViewController cont)
		{
			RestMain client = RestMain.getInstance();
			showSkills = cont;
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ItemSkillCell.class.getResource("/Views/skillCell.fxml"));
		    try {
		      node = loader.load(); //store for later
		      
		      itemController = loader.getController(); //store for later
		      itemController.setModel(this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    setGraphic(node);
			
			
		}


		public SkillCellController getItemController() {
			return itemController;
		}


		public void setItemController(SkillCellController itemController) {
			this.itemController = itemController;
		}
		
		public ItemSkillCell() {
			
		}


		@Override
		protected void updateItem(Skill item, boolean empty)
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
			showSkills.showSkillItem(getItem());
		}
		

		
	}


