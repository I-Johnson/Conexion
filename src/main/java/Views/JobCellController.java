package Views;
import conexion.Job;
import conexion.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ItemJobCell;

public class JobCellController {

    @FXML
    private Label jobCell;
    
    Page parent;
    public Page getParent() {
		return parent;
	}

	public void setParent(Page parent) {
		this.parent = parent;
	}

	ItemJobCell model;
    
    public void setModel(ItemJobCell cell)
    {
    	model = cell;
    }
    
    public void updateView(Job item)
    {
    	if(item ==null)
    	{
    		jobCell.setText("");
    	}
    	else
    	{
    		//add JobName
    		jobCell.setText(item.toString());
    	}
    }

    @FXML
    void OnClickJob(MouseEvent event) {
    	model.showItem();
    }

}