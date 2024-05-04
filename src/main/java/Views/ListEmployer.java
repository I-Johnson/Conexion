package Views;


import conexion.Employer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListEmployer
{
	ObservableList<Employer> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListEmployer()
	{
		
	}
	
	
	
	public void addItem(Employer item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<Employer> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<Employer> items)
	{
		this.items = items;
	}
	
}