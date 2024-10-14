package LLD.ParkingLot.ParkingSpace;


import LLD.ParkingLot.Vehicle.Vehicle;

public class ParkingSpace {
    int spaceId;
    String type;
    boolean isOccupied;
    ParkingTicket ticket;

    public ParkingSpace(int spaceId, String type) {
        this.spaceId = spaceId;
        this.type = type;
        this.isOccupied = false;
        this.ticket = null;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void parkVehicle(Vehicle vehicle){
        if(vehicle.getType().equalsIgnoreCase(type)){
            this.ticket = new ParkingTicket(vehicle.getId(),spaceId);
            this.isOccupied = true;
        }else{
            throw new IllegalArgumentException("Vehicle type does not match parking space type.");
        }
    }

    public void vacate(){
        this.ticket = null;
        this.isOccupied = false;
    }
}
