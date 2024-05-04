package Views;


import conexion.Post;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListPost
{
	ObservableList<Post> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListPost()
	{
		
	}
	
	
	
	public void addItem(Post item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<Post> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<Post> items)
	{
		this.items = items;
	}
	
}