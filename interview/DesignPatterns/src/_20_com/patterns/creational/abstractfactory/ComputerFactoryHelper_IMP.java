package _20_com.patterns.creational.abstractfactory;

public class ComputerFactoryHelper_IMP {

	// 1: It takes ComputerAbstractFactory as parameter and returns Computer
	public static IComputer getComputer(IComputerFactory factory) {
		return factory.createComputer();
	}
}