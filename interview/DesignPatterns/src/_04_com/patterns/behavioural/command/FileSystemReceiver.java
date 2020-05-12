package _04_com.patterns.behavioural.command;

public interface FileSystemReceiver {

	void openFile();

	void writeFile();

	void closeFile();
}