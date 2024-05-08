package Views;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddPersonCellController extends PersonCellController {
	
	@Override
    @FXML
    void OnClickPerson(MouseEvent event) {
    	if(model.getItem() != null) {
    		parent.addPerson(model.getItem());
    		
    	} 
    }
	
}
