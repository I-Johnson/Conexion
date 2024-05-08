package Views;

import conexion.Page;
import conexion.Post;

public class AllPostsViewController extends AllPagesViewController implements AllPagesViewControllerInterface
{
	public void showItem(Page page) {
		Post post = (Post) page;
		vm.showSinglePost(post.getPageID());
	}
	
}
