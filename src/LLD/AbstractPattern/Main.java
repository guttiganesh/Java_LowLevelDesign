package LLD.AbstractPattern;

import LLD.AbstractPattern.Vehicle.Vehicle;
import LLD.AbstractPattern.VehicleFactory.VehicleFactory;

public class Main {
    public static void main(String[] args){
        VehicleFactory luxuryFactory = FactoryProducer.getVehicleFactory("Luxury");
        Vehicle bmw = luxuryFactory.createVehicle("BMW");
        bmw.drive();
        Vehicle mercedes = luxuryFactory.createVehicle("Mercedes");
        mercedes.drive();
        VehicleFactory ordinaryFactory = FactoryProducer.getVehicleFactory("Ordinary");
        Vehicle hyundai = ordinaryFactory.createVehicle("Hyundai");
        hyundai.drive();
        Vehicle tata = ordinaryFactory.createVehicle("TATA");
        tata.drive();
    }
}
