package Views;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddSkillCellController extends SkillCellController{
	@Override
    @FXML
    void OnClickSkill(MouseEvent event) {
    	if(model.getItem() != null) {
    		parent.addSkill(model.getItem());
    		
    	}
    }
}
