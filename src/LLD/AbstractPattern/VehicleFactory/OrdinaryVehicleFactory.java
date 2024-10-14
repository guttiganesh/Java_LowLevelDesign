package LLD.AbstractPattern.VehicleFactory;

import LLD.AbstractPattern.Vehicle.Hyundai;
import LLD.AbstractPattern.Vehicle.Tata;
import LLD.AbstractPattern.Vehicle.Vehicle;

public class OrdinaryVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String type) {
        if(type.equalsIgnoreCase("Tata")){
            return new Tata();
        }else if(type.equalsIgnoreCase("Hyundai")){
            return new Hyundai();
        }
        return null;
    }
}
