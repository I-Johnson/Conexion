package Views;
import conexion.Page;
import conexion.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemPersonCell;

public class PersonCellController {

    @FXML
    private Label personCell;
    
    ItemPersonCell model;
    Page parent;
    
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
    

    public Page getParent() {
		return parent;
	}

	public void setParent(Page parent) {
		this.parent = parent;
	}

	@FXML
    void OnClickPerson(MouseEvent event) {
    	model.showItem();
    }

}