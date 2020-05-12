package _21_com.patterns.creational.builder;

public class Computer {

	// required parameters
	private String HDD;
	private String RAM;

	// optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	// 1: Constructor is private and takes parameter as ComputerBuilder
	private Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	// 2: Builder Class - public static
	public static class ComputerBuilder {

		// required parameters
		private String HDD;
		private String RAM;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		// 3: constructor with mandatory fields
		public ComputerBuilder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}

		// 4: return builder object
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		// 4: return builder object
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		// 5: return actual Computer object
		public Computer build() {
			return new Computer(this);
		}

	}

}