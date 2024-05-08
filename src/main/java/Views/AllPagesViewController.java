package Views;

import conexion.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import models.ListPage;
import models.Text;
import models.ViewTransitionalModel;

public class AllPagesViewController implements AllPagesViewControllerInterface{
	ViewTransitionalModel vm;
	ListPage listPage;
	Page page;
	Text info;
	Page parent;

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Text getInfo() {
		return info;
	}
	public void setInfo(Text info) {
		this.info = info;
	}
	
	public void setPageViewModel(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	

	
	public ViewTransitionalModel getVm() {
		return vm;
	}
	public void setVm(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	public ListPage getListPage() {
		return listPage;
	}
	public Page getParent() {
		return parent;
	}
	public void setParent(Page parent) {
		this.parent = parent;
	}
	public ListView<Page> getAllPageList() {
		return allPageList;
	}
	public void setAllPageList(ListView<Page> allPageList) {
		this.allPageList = allPageList;
	}
	public AllPagesViewControllerInterface getItemShower() {
		return itemShower;
	}



	private final AllPagesViewControllerInterface itemShower;
	
	public AllPagesViewController() {
		itemShower = this;
	}
	
	@FXML
	private ListView<Page> allPageList; 
	
	   @FXML
	    private Label pageDescriptionLabel;

	    @FXML
	    private Button pageEditButton;

	    @FXML
	    private Label pageTitle; 
	    
    public void setListPage(ListPage model)
    {
    	this.listPage= model;
    	allPageList.setCellFactory(new Callback<ListView<Page>, ListCell<Page>>()
		  {

			@Override
			public ListCell<Page> call(ListView<Page> lv)
			{
				PageListCell newCell = new PageListCell(lv,itemShower);
				return newCell;
			}
		  });
    	allPageList.setItems(model.getItems());
    }
	
	public void setAddListModel(ListPage model)
    {
    	this.listPage= model;
    	allPageList.setCellFactory(new Callback<ListView<Page>, ListCell<Page>>()
		  {

			@Override
			public ListCell<Page> call(ListView<Page> lv)
			{
				AddPageListCell newCell = new AddPageListCell(lv,itemShower);
				newCell.getItemController().setParent(parent);
				return newCell;
			}
		  });
    	allPageList.setItems(model.getItems());
    }
	@Override
	public void setModel(ViewTransitionalModel model) {
		// TODO Auto-generated method stub
		vm = model;
		
	}
	@Override
	public void showItem(Page item) {
		// TODO Auto-generated method stub
		
	}

	

	
}
