package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Product.Car;
import LLD.CarRentalSystem.Product.Vehicle;
import LLD.CarRentalSystem.Product.VehicleType;
import LLD.CarRentalSystem.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> storeList = addStores(vehicles);
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(storeList,users);
        //0 User Comes
        User user = users.get(0);
        //1 User search store based on location
        Location location = new Location(523147,"Hyderabd","Telangana");
        Store store = vehicleRentalSystem.getStore(location);
        //2 Get vehicles from the store
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);
        //3 Book Reservation
        Reservation reservation = new Reservation(storeVehicles.get(0),user);
        //4 Generate Bill
        Bill bill = new Bill(reservation);
        Payment payment = new Payment();
        //5 Bill Payment
        payment.payBill(bill);
        //6 Trip Completed submit the vehicle and complete the reservation
        store.completeReservation(reservation);
    }

    private static List<Store> addStores(List<Vehicle> vehicles) {

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;

    }

    private static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleId(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;


    }

    private static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }
}
