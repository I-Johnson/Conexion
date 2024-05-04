package Views;

import conexion.Job;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListJob
{
	ObservableList<Job> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListJob()
	{
		
	}
	
	
	
	public void addItem(Job item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<Job> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<Job> items)
	{
		this.items = items;
	}
	
}