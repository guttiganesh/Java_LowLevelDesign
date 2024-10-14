package LLD.ParkingLot.Vehicle;

public class TwoWheeler implements Vehicle{
    final String id;

    public TwoWheeler(String id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return "TwoWheeler";
    }

    @Override
    public String getId() {
        return id;
    }
}
