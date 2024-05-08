package Views;

import javafx.event.ActionEvent;

public class EditEmployerViewController extends EditPageViewController {

	@Override
	void onClickSaveButton(ActionEvent event) {
		saveChanges();
		vm.showSingleEmployer(page.getPageID());		
		
	}

}
