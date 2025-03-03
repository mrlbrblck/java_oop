package models;

public class Hotel {
    private final String hotelId;
    private final String name;
    private final String location;
    private int availableRooms;
    private final double pricePerNight;

    public Hotel(String hotelId, String name, String location, int availableRooms, double pricePerNight) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.availableRooms = availableRooms;
        this.pricePerNight = pricePerNight;
    }

    public String getHotelId() { return hotelId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getAvailableRooms() { return availableRooms; }
    public double getPricePerNight() { return pricePerNight; }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
    @Override
    public String toString() {
        return """
               Hotel Details:
                 - ID: """ + hotelId + "\n" +
                "  - Name: " + name + "\n" +
                "  - Location: " + location + "\n" +
                "  - Price per Night: " + pricePerNight;
    }
}
