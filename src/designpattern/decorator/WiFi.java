package designpattern.decorator;

public class WiFi extends FlightSeatDecorator {
    public WiFi(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\nWiFi";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 10.0;
    }
}
