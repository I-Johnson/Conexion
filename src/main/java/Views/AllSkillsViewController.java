package Views;


import conexion.Page;
import conexion.Skill;

public class AllSkillsViewController extends AllPagesViewController implements AllPagesViewControllerInterface{
	 public void showItem(Page page) {
	    	Skill skill = (Skill) page;
	    	vm.showSingleSkill(skill.getPageID());
	    }
}
