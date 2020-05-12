package _23_com.patterns.creational.singleton;

public class DCLSingleton {

	// TODO remember volatile, static and private
	private static volatile DCLSingleton INSTANCE;

	// 1: private constructor
	private DCLSingleton() {
	}

	public DCLSingleton getInstance() {
		if (INSTANCE == null) {
			// 2: synchronized Class instance
			synchronized (DCLSingleton.class) {
				if (INSTANCE == null)
					INSTANCE = new DCLSingleton();
			}
		}
		return INSTANCE;

	}

}
