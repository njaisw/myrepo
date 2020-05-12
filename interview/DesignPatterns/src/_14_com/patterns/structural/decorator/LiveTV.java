package _14_com.patterns.structural.decorator;

public class LiveTV extends FlightSeatDecorator {
	public LiveTV(FlightSeat flightSeat) {
		super(flightSeat);
	}

	@Override
	public String getFacilities() {
		return this.flightSeat.getFacilities() + "\nLiveTV";
	}

	@Override
	public Double getCost() {
		return this.flightSeat.getCost() + 10.0;
	}
}