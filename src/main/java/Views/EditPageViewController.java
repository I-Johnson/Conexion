package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public abstract class EditPageViewController extends PageViewController implements AllPagesViewControllerInterface{
	@FXML
    private TextArea changeDescriptionArea;

    @FXML
    private TextField changeNameField;

    @FXML
    private Button employersButton;

    @FXML
    private Button jobsButton;

    @FXML
    private Button jobseekersButton;

    @FXML
    private Button postsButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button skillsButton;

    @FXML
    void onClickEmployersButton(ActionEvent event) {
    	vm.showAddEmployer();
    }

    @FXML
    void onClickJobsButton(ActionEvent event) {
    	vm.showAddJob();
    }

    @FXML
    void onClickJobseekersButton(ActionEvent event) {
    	vm.showAddJobseeker();
    }

    @FXML
    void onClickPostsButton(ActionEvent event) {
    	vm.showAddPost();
    }

   
    @FXML
    void onClickSkillsButton(ActionEvent event) {
    	vm.showAddSkill();
    }
    @FXML
    abstract void onClickSaveButton(ActionEvent event);

	public TextArea getChangeDescriptionArea() {
		return changeDescriptionArea;
	}
	

	public void setChangeDescriptionArea(TextArea changeDescriptionArea) {
		this.changeDescriptionArea = changeDescriptionArea;
	}

	public TextField getChangeNameField() {
		return changeNameField;
	}

	public void setChangeNameField(TextField changeNameField) {
		this.changeNameField = changeNameField;
	}
	@Override
	public void switchToEditView() {
		//already in edit view; do nothing (can't click said button anyway)
	}
	public void saveChanges() {
		page.setPageTitle(this.getChangeNameField().getText());
		page.setPageDescription(this.getChangeDescriptionArea().getText());
		page.push();
	}
}
