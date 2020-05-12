package _02_com.patterns.behavioural.state;
public class TVStartState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}

}