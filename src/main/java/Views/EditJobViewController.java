package Views;

import javafx.event.ActionEvent;

public class EditJobViewController extends EditPageViewController {

	@Override
	void onClickSaveButton(ActionEvent event) {
		saveChanges();
		vm.showSingleJob(page.getPageID());		
		
	}

}
