package Views;

import java.io.IOException;

import org.springframework.web.client.RestClient;

import conexion.Page;
import conexion.RestMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class PageListCell extends ListCell<Page> { 
	AllPagesViewControllerInterface showController;
	PageListCellController itemController;
	Node node;
	
	public PageListCell(ListView<Page> list, AllPagesViewControllerInterface cont) {
		RestMain client = RestMain.getInstance();
		showController = cont;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PageListCell.class.getResource("/views/pageListCellView.fxml"));
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
	
	public PageListCell() {
	}
	
	@Override
	protected void updateItem(Page item, boolean empty)
	{
		if(!empty)
		{
			itemController.updateView(item);
		}
		else
		{
			
			itemController.updateView(null);
		}
		super.updateItem(item, empty);
	}
	public void showItem()
	{
		showController.showItem(getItem());
	}


	public AllPagesViewControllerInterface getShowController() {
		return showController;
	}


	public void setShowController(AllPagesViewControllerInterface showController) {
		this.showController = showController;
	}


	public PageListCellController getItemController() {
		return itemController;
	}


	public void setItemController(PageListCellController itemController) {
		this.itemController = itemController;
	}


	public Node getNode() {
		return node;
	}


	public void setNode(Node node) {
		this.node = node;
	}
}
