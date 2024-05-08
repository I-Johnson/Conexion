package Views;

import javafx.event.ActionEvent;

public class EditPostViewController extends EditPageViewController {

	@Override
	void onClickSaveButton(ActionEvent event) {
		saveChanges();
		vm.showSinglePost(page.getPageID());		
		
	}

}
