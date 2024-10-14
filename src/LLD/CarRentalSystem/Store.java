package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Product.Vehicle;
import LLD.CarRentalSystem.Product.VehicleType;
import LLD.CarRentalSystem.Reservation.Reservation;

import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservationList;

    public void setVehicles(List<Vehicle> vehicles){
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return inventoryManagement.getVehicles();
    }

    public String completeReservation(Reservation reservation){
        //Logic
        return "SUCCESS";
    }
}
