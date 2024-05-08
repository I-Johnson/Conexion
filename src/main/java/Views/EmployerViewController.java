package Views;


public class EmployerViewController extends UserViewController {

	@Override
	public void switchToEditView() {
		vm.showEditEmployer(page.getPageID());
	}
}
