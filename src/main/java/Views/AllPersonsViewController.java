package Views;

import conexion.Page;
import conexion.User;

public class AllPersonsViewController extends AllPagesViewController implements AllPagesViewControllerInterface{
	public void showItem(Page page) {
		User user = (User) page;
		vm.showSinglePerson(user.getPageID());
	}
    
}
