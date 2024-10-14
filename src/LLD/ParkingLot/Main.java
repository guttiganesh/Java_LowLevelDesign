package LLD.ParkingLot;

import LLD.ParkingLot.ParkigLotManager.ParkingLotManager;
import LLD.ParkingLot.Parking.NormalParkingStrategy;
import LLD.ParkingLot.ParkingSpace.ParkingTicket;
import LLD.ParkingLot.Pricing.HourlyPricingStrategy;
import LLD.ParkingLot.Vehicle.FourWheeler;
import LLD.ParkingLot.Vehicle.TwoWheeler;
import LLD.ParkingLot.Vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        // Initialize ParkingLotManager
        ParkingLotManager parkingLotManager = new ParkingLotManager();

        // Add vehicle types with managers
        parkingLotManager.addTwoWheelerType(10, new HourlyPricingStrategy(5.0), new NormalParkingStrategy());
        parkingLotManager.addFourWheelerType(15, new HourlyPricingStrategy(10.0), new NormalParkingStrategy());

        // Park vehicles
        Vehicle bike = new TwoWheeler("TW-123");
        Vehicle car = new FourWheeler("FW-456");

        ParkingTicket bikeTicket = parkingLotManager.parkVehicle("TwoWheeler", bike);
        if (bikeTicket != null) {
            System.out.println("Bike parked at space: " + bikeTicket.getSpaceId());
        } else {
            System.out.println("No available space for bike.");
        }

        ParkingTicket carTicket = parkingLotManager.parkVehicle("FourWheeler", car);
        if (carTicket != null) {
            System.out.println("Car parked at space: " + carTicket.getSpaceId());
        } else {
            System.out.println("No available space for car.");
        }

        // Vacate spaces
        if (bikeTicket != null) {
            double bikeCost = parkingLotManager.vacateParkingSpace("TwoWheeler", bikeTicket.getSpaceId());
            System.out.println("Bike cost: $" + bikeCost);
        }

        if (carTicket != null) {
            double carCost = parkingLotManager.vacateParkingSpace("FourWheeler", carTicket.getSpaceId());
            System.out.println("Car cost: $" + carCost);
        }
    }
}
