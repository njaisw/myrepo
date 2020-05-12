package _23_com.patterns.creational.singleton;

public class EagerInitializedSingleton {

	// 1: static final
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// 2: private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	// 3: static method
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}
