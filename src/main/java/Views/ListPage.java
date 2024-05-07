package Views;

import conexion.Page;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListPage {
	
		ObservableList<Page> items = FXCollections.observableArrayList();
			  
		
		public ListPage()
		{
			
		}
		
		
		
		public void addItem(Page item)
		{
			items.add(item);
		}


		
		
		
		/**
		 * @return the items
		 */
		public ObservableList<Page> getItems()
		{
			return items;
		}



		/**
		 * @param items the items to set
		 */
		public void setItems(ObservableList<Page> items)
		{
			this.items = items;
		}

	}
