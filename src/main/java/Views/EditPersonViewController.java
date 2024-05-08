package Views;

import javafx.event.ActionEvent;

public class EditPersonViewController extends EditPageViewController {

	@Override
	void onClickSaveButton(ActionEvent event) {
		saveChanges();
		vm.showSinglePerson(page.getPageID());		
		
	}

}
