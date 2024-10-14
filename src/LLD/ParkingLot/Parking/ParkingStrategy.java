package LLD.ParkingLot.Parking;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpace findParkingSpace(List<ParkingSpace> parkingspaces);
}
