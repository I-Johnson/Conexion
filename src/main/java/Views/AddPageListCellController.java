package Views;

import conexion.Page;
import conexion.Skill;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddPageListCellController extends PageListCellController{
	@Override
	@FXML
    void onClickedPageNameLabel(MouseEvent event) {
    	if(this.getModel().getItem()!=null) {
    		Page page = this.getModel().getItem();
    		if(page instanceof Skill) {
    			parent.addSkill((Skill)page);
    		}
    	}
    }
	@Override
	@FXML
    void onItemClicked(MouseEvent event) 
    {
		if(this.getModel().getItem()!=null) {
    		Page page = this.getModel().getItem();
    		if(page instanceof Skill) {
    			parent.addSkill((Skill)page);
    		}
    	}
    }
}
