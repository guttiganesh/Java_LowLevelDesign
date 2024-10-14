package LLD.CarRentalSystem.Reservation;

import LLD.CarRentalSystem.Product.Vehicle;
import LLD.CarRentalSystem.User;

import java.util.Date;

public class Reservation {
    int reservationId;
    Vehicle vehicle;
    User user;
    Date fromDate;
    Date toDate;
    Date bookingDate;
    ReservationStatus reservationStatus;

    public Reservation(Vehicle vehicle, User user) {
        //generateNewId
        this.reservationId = 12345;
        this.vehicle = vehicle;
        this.user = user;
        reservationStatus = ReservationStatus.SCHEDULED;
    }
}
