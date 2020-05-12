package _1_com.java.practice.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	    //Usage Callable returns which can returned with the futureTask
		//futuretask is an implementation of future
		final FutureTask<String> future = new FutureTask<String>(()-> {return "Hello World";});
		Thread thread = new Thread (future);
		thread.start();
		System.out.println(future.get());
		
		

	}

}
