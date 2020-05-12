package _16_com.patterns.structural.bridge;

// Demonstration of bridge design pattern 
class BridgePatternTest {

	public static void main(String[] args) {

		Vehicle vehicle1 = new Car(new Produce(), new Assemble());
		vehicle1.manufacture();
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();
	}
}
