package Views;

import conexion.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListSkill
{
	ObservableList<Skill> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListSkill()
	{
		
	}
	
	
	
	public void addItem(Skill item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<Skill> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<Skill> items)
	{
		this.items = items;
	}
	
}