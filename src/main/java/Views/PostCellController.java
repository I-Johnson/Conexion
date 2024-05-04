package Views;
import conexion.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemPostCell;

public class PostCellController {

    @FXML
    private Label postCell;
    
    ItemPostCell model;
    
    public void setModel(ItemPostCell cell)
    {
    	model = cell;
    }
    
    public void updateView(Post item)
    {
    	if(item ==null)
    	{
    		postCell.setText("");
    	}
    	else
    	{
    		postCell.setText(item.toString());
    	}
    }

    @FXML
    void OnClickPost(MouseEvent event) {
    	model.showPostItem();
    }

}