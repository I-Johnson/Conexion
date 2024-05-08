package Views;

import javafx.event.ActionEvent;

public class EditSkillViewController extends EditPageViewController {

	@Override
	void onClickSaveButton(ActionEvent event) {
		saveChanges();
		vm.showSingleSkill(page.getPageID());		
		
	}

}
