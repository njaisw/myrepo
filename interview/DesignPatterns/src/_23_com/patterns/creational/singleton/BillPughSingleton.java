package _23_com.patterns.creational.singleton;

/*
 * 1:Private constructor
 * 2:Private inner static class which has eager intialization 
 * 3:private static final BillPughSingleton INSTANCE
 * 3:public getInstance method;
 */
public class BillPughSingleton {
	// 1: private constructor
	private BillPughSingleton() {
	}

	// 2: private inner static class
	private static class SingletonHelper {
		// 3:static final outer instance
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	// 4: static SingletonHelper.INSTANCE
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
