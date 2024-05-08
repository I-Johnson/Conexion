package Views;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddEmployerCellController extends EmployerCellController{
	@Override
    @FXML
    void OnClickEmployer(MouseEvent event) {
    	if(model.getItem() != null) {
    		parent.addEmployer(model.getItem());
    		
    	}
    }
}
