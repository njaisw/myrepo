package _20_com.patterns.creational.abstractfactory;
// implements ComputerAbstractFactory
public class PCFactory implements IComputerFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public IComputer createComputer() {
		return new PC(ram, hdd, cpu);
	}

}