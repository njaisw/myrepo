package _1_com.java.practice.concurrency;

interface Callback {
	void callback(); // would be in any signature
}

public class RunnableWithCallbacks {

	

	public static void main(String[] args) {
		
		Callback c = new Callback() {

			public void callback() {
				System.out.println("Hello");
			}
		};
		 
		Thread thread = new Thread(new MyThread(c));
		thread.start();
	}

	static class MyThread implements Runnable {

		Callback c;

		public MyThread(Callback c) {
			this.c = c;
		}

		public void run() {
			// some work
			this.c.callback(); // callback
		}
	}

}
