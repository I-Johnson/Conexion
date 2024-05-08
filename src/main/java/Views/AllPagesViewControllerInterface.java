package Views;

import conexion.Page;
import models.ViewTransitionalModel;

public interface AllPagesViewControllerInterface {
	public void setModel(ViewTransitionalModel model);
	public void showItem(Page item);
}
