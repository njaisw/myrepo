package _14_com.patterns.structural.decorator;
public class MainCabinSeat implements FlightSeat {
    @Override
    public String getFacilities() {
        return "Main Cabin Seat";
    }
 
    @Override
    public Double getCost() {
        return 500.0;
    }
}