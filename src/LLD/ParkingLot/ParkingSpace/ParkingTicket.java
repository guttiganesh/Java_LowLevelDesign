package LLD.ParkingLot.ParkingSpace;

public class ParkingTicket {
    String vehicleId;
    long startTime;
    int spaceId;

    public ParkingTicket(String vehicleId, int spaceId) {
        this.vehicleId = vehicleId;
        this.spaceId = spaceId;
        this.startTime = System.currentTimeMillis();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getSpaceId() {
        return spaceId;
    }
}
