package Views;

import models.ViewTransitionalModel;

public class GoBackCommand implements Command {
	ViewTransitionalModel vm;
	
	public GoBackCommand(ViewTransitionalModel vm) {
		this.vm = vm;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		vm.showPreviousPage();
	}

}
