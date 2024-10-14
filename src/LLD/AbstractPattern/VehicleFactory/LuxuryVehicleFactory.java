package LLD.AbstractPattern.VehicleFactory;

import LLD.AbstractPattern.Vehicle.BMW;
import LLD.AbstractPattern.Vehicle.Mercedes;
import LLD.AbstractPattern.Vehicle.Vehicle;

public class LuxuryVehicleFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(String type) {
        if(type.equalsIgnoreCase("BMW")){
            return new BMW();
        } else if (type.equalsIgnoreCase("Mercedes")) {
            return new Mercedes();
        }
        return null;
    }
}
