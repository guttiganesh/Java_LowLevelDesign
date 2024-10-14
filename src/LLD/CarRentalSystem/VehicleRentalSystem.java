package LLD.CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> users;

    public VehicleRentalSystem(List<Store> storeList, List<User> users) {
        this.storeList = storeList;
        this.users = users;
    }

    public Store getStore(Location location){
        //Logic
        return storeList.get(0);
    }
}
