package Views;
import conexion.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemPersonCell;

public class PersonCellController {

    @FXML
    private Label personCell;
    
    ItemPersonCell model;
    
    public void setModel(ItemPersonCell cell)
    {
    	model = cell;
    }
    
    public void updateView(Person item)
    {
    	if(item ==null)
    	{
    		personCell.setText("");
    	}
    	else
    	{
    		//add JobName
    		personCell.setText(item.toString());
    	}
    }

    @FXML
    void OnClickPerson(MouseEvent event) {
    	model.showItem();
    }

}