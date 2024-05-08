package Views;


import conexion.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.ListPage;
import models.ViewTransitionalModel;

public abstract class PageViewController implements AllPagesViewControllerInterface{
	@FXML
	private Button editButton;
	@FXML
	private Label pageName;
	ViewTransitionalModel vm;
	AllPagesViewControllerInterface itemShower;
	
	@FXML
	private Label pageDescriptionLabel;

	
	Page page;
	ListPage listPage;
	
	public Button getEditButton() {
		return editButton;
	}
	public void setEditButton(Button editButton) {
		this.editButton = editButton;
	}
	public ViewTransitionalModel getVm() {
		return vm;
	}
	public void setVm(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Label getPageName() {
		return pageName;
	}
	public void setPageName(Label pageName) {
		this.pageName = pageName;
	}
	public abstract void switchToEditView();
	@FXML
	public void onClickEditButton(ActionEvent event) {
		if(vm.getLoggedIn()==null) {
			return;
		}
		if(page.getEditors().contains(vm.getLoggedIn().getPageID())) {
			switchToEditView();
		}
		else {
			System.out.println("Permission Not Granted");
		}
	};
	
	   @FXML
	    void onClickEmployersButton(ActionEvent event) {
		   vm.showAllEmployers(page);
	    }

	    @FXML
	    void onClickJobsButton(ActionEvent event) {
	    	vm.showAllJobs(page);
	    }

	    @FXML
	    void onClickPersonsButton(ActionEvent event) {
	    	vm.showAllPersons(page);
	    }

	    @FXML
	    void onClickPostsButton(ActionEvent event) {
	    	vm.showAllPosts(page);
	    }

	    @FXML
	    void onClickSkillsButton(ActionEvent event) {
	    	vm.showAllSkills(page);
	    }
    @FXML
    private ListView<Page> allPagesList;

    public void setModel(ViewTransitionalModel model) {
		vm = model;
	}
    public void showItem(Page page) {
    }

    @FXML
    void onClickLogOutButton(ActionEvent event) {
    	vm.setLoggedIn(null);
    	vm.changetoLoginView();
    }
}
