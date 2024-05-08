package Views;

import conexion.Employer;
import conexion.Page;

public class AllEmployersViewController extends AllPagesViewController implements AllPagesViewControllerInterface{
//	
	public void showItem(Page page) {
		Employer employer = (Employer) page;
		vm.showSingleEmployer(employer.getPageID());
	}
}
