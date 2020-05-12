package x.com.java.practice.singleton;

public class DCLSingleton {
    //IMP: volatile
	private static volatile DCLSingleton INSTANCE;

	private DCLSingleton() {
	}

	public DCLSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DCLSingleton.class) {
				if (INSTANCE == null)
					INSTANCE = new DCLSingleton();
			}
		}
		return INSTANCE;

	}

}
