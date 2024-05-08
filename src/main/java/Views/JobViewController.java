package Views;

public class JobViewController extends PageViewController{
	@Override
	public void switchToEditView() {
		vm.showEditJob(page.getPageID());
	}
}
