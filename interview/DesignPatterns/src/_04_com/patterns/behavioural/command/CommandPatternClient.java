package _04_com.patterns.behavioural.command;

/*
 * 1: Receiver remains constanst only command and invoker chnages
 */
public class CommandPatternClient {

	public static void main(String[] args) {
		// Creating the receiver object
		FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

		// creating command and associating with receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);

		// Creating invoker and associating with Command
		FileInvoker file = new FileInvoker(openFileCommand);

		// perform action on invoker object
		file.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}

}