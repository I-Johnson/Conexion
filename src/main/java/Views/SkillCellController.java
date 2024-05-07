package Views;
import conexion.Page;
import conexion.Skill;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemSkillCell;

public class SkillCellController {

    @FXML
    private Label skillCell;
    
    ItemSkillCell model;
    Page parent;
    
    public Page getParent() {
		return parent;
	}

	public void setParent(Page parent) {
		this.parent = parent;
	}

	public void setModel(ItemSkillCell cell)
    {
    	model = cell;
    }
    
    public void updateView(Skill item)
    {
    	if(item ==null)
    	{
    		skillCell.setText("");
    	}
    	else
    	{
    		skillCell.setText(item.toString());
    	}
    }

    @FXML
    void OnClickSkill(MouseEvent event) {
    	model.showItem();
    }

}