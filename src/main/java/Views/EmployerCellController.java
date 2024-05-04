package Views;
import conexion.Employer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemEmployerCell;

public class EmployerCellController {

    @FXML
    private Label employerCell;
    
    ItemEmployerCell model;
    
    public void setModel(ItemEmployerCell cell)
    {
    	model = cell;
    }
    
    public void updateView(Employer item)
    {
    	if(item ==null)
    	{
    		employerCell.setText("");
    	}
    	else
    	{
    		//add JobName
    		employerCell.setText(item.toString());
    	}
    }

    @FXML
    void OnClickEmployer(MouseEvent event) {
    	model.showItem();
    }

}