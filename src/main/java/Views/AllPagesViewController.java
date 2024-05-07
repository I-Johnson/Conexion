package Views;

import conexion.Employer;
import conexion.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Text;
import models.ViewTransitionalModel;

public class AllPagesViewController {
	ViewTransitionalModel vm;
	ListPage listPage;
	Page page;
	Text info;


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
	
	@FXML
	private ListView<Page> allPageList; 
	
	   @FXML
	    private Label pageDescriptionLabel;

	    @FXML
	    private Button pageEditButton;

	    @FXML
	    private Label pageTitle;
	
//	public void setPageName() {
//		pageTitle.textProperty().bind(this.info.getPageName());
//		this.info.getPageName().set(page.getUserName());
//	}
//	
//	public void setPageDescriptionName() {
//		pageDescriptionLabel.textProperty().bind(this.info.getEmployerDescription());
//		this.info.getEmployerDescription().set(employer.getUserBio());
//	}
//	
//	public void setEditInfo() {
//		employerNameTextField.textProperty().set(employer.getUserName());
//		employerDescriptionTextField.textProperty().set(employer.getUserBio());
//	}
	
	public void showEmployerItem(Employer item) {
		vm.showSingleEmployer(item.getPageID());
	}
	
}
