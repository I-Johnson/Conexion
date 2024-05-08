package Views;


import conexion.Job;
import conexion.Page;
public class AllJobsViewController extends AllPagesViewController implements AllPagesViewControllerInterface{
	
	public void showItem(Page page) {
		Job job = (Job) page;
		vm.showSingleJob(job.getPageID());
	}

	
}
