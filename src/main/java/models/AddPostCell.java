package models;

import java.io.IOException;

import Views.AllPostsViewController;
import conexion.Post;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddPostCell extends ItemPostCell{
	
	public AddPostCell(ListView<Post> list, AllPostsViewController cont)
	{
		super();
		RestMain client = RestMain.getInstance();
		showPosts = cont;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ItemPostCell.class.getResource("/Views/addPostCell.fxml"));
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
