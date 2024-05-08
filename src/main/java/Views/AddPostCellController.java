package Views;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddPostCellController extends PostCellController{
	@Override
    @FXML
    void OnClickPost(MouseEvent event) {
    	if(model.getItem() != null) {
    		parent.addPost(model.getItem());
    		
    	}
    }
}
