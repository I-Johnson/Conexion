package Views;

import java.io.IOException;

import conexion.Page;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class AddPageListCell extends PageListCell{
	public AddPageListCell(ListView<Page> list, AllPagesViewControllerInterface cont) {
		super();
		RestMain client = RestMain.getInstance();
		showController = cont;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PageListCell.class.getResource("/views/addPageListCellView.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      itemController = loader.getController(); //store for later
	      itemController.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
	    System.out.println(node.toString());
	}
}
