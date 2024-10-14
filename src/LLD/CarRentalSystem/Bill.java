package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Reservation.Reservation;

public class Bill {
    Reservation reservation;
    double amount;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        amount = calculateAmount();
        isPaid = false;
    }

    private double calculateAmount() {
        //Logic
        return 100;
    }
}
