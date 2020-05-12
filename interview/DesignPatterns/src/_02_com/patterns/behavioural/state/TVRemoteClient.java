package _02_com.patterns.behavioural.state;
public class TVRemoteClient {

	public static void main(String[] args) {
		
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		
		context.setState(tvStartState);
		context.doAction();
				
		context.setState(tvStopState);
		context.doAction();
		
	}

}