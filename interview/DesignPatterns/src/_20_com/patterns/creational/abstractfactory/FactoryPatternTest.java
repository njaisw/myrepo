package _20_com.patterns.creational.abstractfactory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		IComputer pc = ComputerFactoryHelper_IMP.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		IComputer server = ComputerFactoryHelper_IMP.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}