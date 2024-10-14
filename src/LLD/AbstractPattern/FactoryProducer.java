package LLD.AbstractPattern;

import LLD.AbstractPattern.VehicleFactory.LuxuryVehicleFactory;
import LLD.AbstractPattern.VehicleFactory.OrdinaryVehicleFactory;
import LLD.AbstractPattern.VehicleFactory.VehicleFactory;

public class FactoryProducer {
    public static VehicleFactory getVehicleFactory(String factoryType){
        if(factoryType.equalsIgnoreCase("Luxury")){
            return new LuxuryVehicleFactory();
        } else if (factoryType.equalsIgnoreCase("Ordinary")) {
            return new OrdinaryVehicleFactory();
        }
        return null;
    }
}
