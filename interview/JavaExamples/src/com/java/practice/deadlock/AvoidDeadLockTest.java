package com.java.practice.deadlock;

import com.java.practice.deadlock.ResolveDeadLockTest.A;
import com.java.practice.deadlock.ResolveDeadLockTest.B;

public class AvoidDeadLockTest {

	public static void main(String[] args) {
		
		ResolveDeadLockTest test = new ResolveDeadLockTest();

		final A a = test.new A();
		final B b = test.new B();

		Runnable block1 = new Runnable() {
			public void run() {
				synchronized (b) {
					try {
						// Adding delay so that both threads can start trying to
						// lock resources
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Thread-1 have A but need B also
					synchronized (a) {
						System.out.println("In block 1");
					}
				}
			}
		};

// Thread-2
		Runnable block2 = new Runnable() {
			public void run() {
				synchronized (b) {
					// Thread-2 have B but need A also
					synchronized (a) {
						System.out.println("In block 2");
					}
				}
			}
		};
	}
}