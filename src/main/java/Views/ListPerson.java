package Views;


import conexion.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListPerson
{
	ObservableList<Person> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListPerson()
	{
		
	}
	
	
	
	public void addItem(Person item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<Person> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<Person> items)
	{
		this.items = items;
	}
	
}