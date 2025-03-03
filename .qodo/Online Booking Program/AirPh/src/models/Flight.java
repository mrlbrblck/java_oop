package models;

public class Flight {
    private final String flightId;
    private final String airline;
    private final String origin;
    private final String destination;
    private final String departureTime;
    private final String arrivalTime;
    private final double price;
    private int seatsAvailable;

    public Flight(String flightId, String airline, String origin, String destination, 
                  String departureTime, String arrivalTime, double price, int seatsAvailable) {
        this.flightId = flightId;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() { return flightId; }
    public String getAirline() { return airline; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public double getPrice() { return price; }
    public int getSeatsAvailable() { return seatsAvailable; }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightId + '\'' +
                ", airline='" + airline + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", seatsAvailable=" + seatsAvailable +
                '}';
    }
}
