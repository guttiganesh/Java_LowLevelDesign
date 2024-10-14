package LLD.CarRentalSystem;

public class Location {
    String address;
    int pincode;
    String city;
    String state;
    String country;

    public Location(int pincode, String city, String state) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }
}
