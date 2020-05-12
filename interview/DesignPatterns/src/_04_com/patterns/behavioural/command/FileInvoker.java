package _04_com.patterns.behavioural.command;

// Invoker is a class which Command
public class FileInvoker {

	public Command command;

	public FileInvoker(Command c) {
		this.command = c;
	}

	public void execute() {
		this.command.execute();
	}
}