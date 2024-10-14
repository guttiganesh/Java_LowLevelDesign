package LLD.ParkingLot.Parking;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import LLD.ParkingLot.Pricing.PricingStrategy;

import java.util.List;

public class NormalParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpace findParkingSpace(List<ParkingSpace> parkingspaces) {
        for(ParkingSpace space:parkingspaces){
            if(!space.isOccupied()) return space;
        }
        return null;
    }
}
