package Views;

public class CommandButton {
	private Command command;
	
	public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        if (command != null) {
            command.execute();
        }
    }
	
}
