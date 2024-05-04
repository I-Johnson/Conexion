package Views;
import conexion.Skill;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemSkillCell;

public class SkillCellController {

    @FXML
    private Label skillCell;
    
    ItemSkillCell model;
    
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