package Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class UserViewController extends PageViewController{
	  @FXML
	  private Label pageDescriptionLabel;

	public Label getPageDescriptionLabel() {
		return pageDescriptionLabel;
	}

	public void setPageDescriptionLabel(Label pageDescriptionLabel) {
		this.pageDescriptionLabel = pageDescriptionLabel;
	}


}
