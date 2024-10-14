package LLD.ParkingLot.ParkigLotManager;

import LLD.ParkingLot.Parking.ParkingStrategy;
import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import LLD.ParkingLot.ParkingSpace.ParkingTicket;
import LLD.ParkingLot.Pricing.PricingStrategy;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotManager {
    private final Map<String, List<ParkingSpace>> parkingSpaces;
    private final Map<String, PricingStrategy> pricingStrategies;
    private final Map<String, ParkingStrategy> parkingStrategies;

    public ParkingLotManager() {
        this.parkingSpaces = new HashMap<>();
        this.pricingStrategies = new HashMap<>();
        this.parkingStrategies = new HashMap<>();
    }

    public void addVehicleType(String vehicleType, int numberOfSpaces, PricingStrategy pricingStrategy, ParkingStrategy parkingStrategy) {
        if (!parkingSpaces.containsKey(vehicleType)) {
            parkingSpaces.put(vehicleType, new ArrayList<>());
        }
        for (int i = 1; i <= numberOfSpaces; i++) {
            parkingSpaces.get(vehicleType).add(new ParkingSpace(i, vehicleType));
        }
        pricingStrategies.put(vehicleType, pricingStrategy);
        parkingStrategies.put(vehicleType, parkingStrategy);
    }

    public ParkingTicket parkVehicle(String vehicleType, Vehicle vehicle) {
        List<ParkingSpace> spaces = parkingSpaces.get(vehicleType);
        ParkingStrategy parkingStrategy = parkingStrategies.get(vehicleType);
        PricingStrategy pricingStrategy = pricingStrategies.get(vehicleType);

        if (spaces != null && parkingStrategy != null && pricingStrategy != null) {
            ParkingSpace space = parkingStrategy.findParkingSpace(spaces);
            if (space != null) {
                ParkingTicket ticket = new ParkingTicket(vehicle.getId(), space.getSpaceId());
                space.parkVehicle(vehicle);
                return ticket;
            }
        }
        return null;
    }

    public double vacateParkingSpace(String vehicleType, int spaceId) {
        List<ParkingSpace> spaces = parkingSpaces.get(vehicleType);
        PricingStrategy pricingStrategy = pricingStrategies.get(vehicleType);

        if (spaces != null && pricingStrategy != null && spaceId > 0 && spaceId <= spaces.size()) {
            ParkingSpace space = spaces.get(spaceId - 1);
            if (space.isOccupied()) {
                long duration = System.currentTimeMillis() - space.getTicket().getStartTime();
                double cost = pricingStrategy.calculatePrice(duration);
                space.vacate();
                return cost;
            }
        }
        return 0;
    }

    public void addTwoWheelerType(int numberOfSpaces, PricingStrategy pricingStrategy, ParkingStrategy parkingStrategy) {
        addVehicleType("TwoWheeler", numberOfSpaces, pricingStrategy, parkingStrategy);
    }

    public void addFourWheelerType(int numberOfSpaces, PricingStrategy pricingStrategy, ParkingStrategy parkingStrategy) {
        addVehicleType("FourWheeler", numberOfSpaces, pricingStrategy, parkingStrategy);
    }
}

