package Views;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddJobCellController extends JobCellController{
	@Override
    @FXML
    void OnClickJob(MouseEvent event) {
    	if(model.getItem() != null) {
    		parent.addJob(model.getItem());
    		
    	}
    }
}
