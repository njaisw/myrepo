package _14_com.patterns.structural.decorator;

/*
 * 1: Decorator class is abstract
 * 2: Implements Component Class
 * 3: Has Component class in Constructor
 * 
 */
public abstract class FlightSeatDecorator implements FlightSeat {

	protected FlightSeat flightSeat;

	public FlightSeatDecorator(FlightSeat flightSeat) {
		this.flightSeat = flightSeat;
	}

	public abstract String getFacilities();

	public abstract Double getCost();
}