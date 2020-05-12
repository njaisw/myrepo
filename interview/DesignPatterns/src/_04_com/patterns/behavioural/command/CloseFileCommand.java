package _04_com.patterns.behavioural.command;

// It is an implementation of Command which has Receiver Interface
public class CloseFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	public CloseFileCommand(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		this.fileSystem.closeFile();
	}

}