package LLD.ParkingLot.Vehicle;

public class FourWheeler implements Vehicle{
    final String id;

    public FourWheeler(String id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return "FourWheeler";
    }

    @Override
    public String getId() {
        return id;
    }
}
