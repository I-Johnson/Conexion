package models;

import java.io.IOException;

import Views.AllPostsViewController;
import Views.PostCellController;
import conexion.Post;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ItemPostCell extends ListCell<Post> {
	AllPostsViewController showPosts; 
	PostCellController itemController;
	Node node;

		
		public ItemPostCell(ListView<Post> list, AllPostsViewController cont)
		{
			RestMain client = RestMain.getInstance();
			showPosts = cont;
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ItemPostCell.class.getResource("/Views/postCell.fxml"));
		    try {
		      node = loader.load(); //store for later
		      
		      itemController = loader.getController(); //store for later
		      itemController.setModel(this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    setGraphic(node);
			
			
		}


		@Override
		protected void updateItem(Post item, boolean empty)
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

		
		public void showPostItem()
		{
			showPosts.showPostItem(getItem());
		}
		

		
	}


