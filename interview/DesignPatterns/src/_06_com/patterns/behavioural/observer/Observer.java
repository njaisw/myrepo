package _06_com.patterns.behavioural.observer;

public interface Observer {

	// method to update the observer, used by subject
	public void callback();

	// attach with subject to observe
	public void setSubject(Subject sub);
}