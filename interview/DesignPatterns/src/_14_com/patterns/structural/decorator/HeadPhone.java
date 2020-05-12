package _14_com.patterns.structural.decorator;

public class HeadPhone extends FlightSeatDecorator {

	public HeadPhone(FlightSeat flightSeat) {
		super(flightSeat);
	}

	@Override
	public String getFacilities() {
		return this.flightSeat.getFacilities() + "\nHeadPhobe";
	}

	@Override
	public Double getCost() {
		return this.flightSeat.getCost() + 10.0;
	}
}