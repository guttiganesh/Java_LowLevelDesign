package LLD.AbstractPattern.VehicleFactory;

import LLD.AbstractPattern.Vehicle.Vehicle;

public interface VehicleFactory {
    public Vehicle createVehicle(String type);
}
