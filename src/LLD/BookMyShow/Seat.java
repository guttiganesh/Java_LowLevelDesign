package LLD.BookMyShow;

import LLD.BookMyShow.Enums.SeatCategory;

public class Seat {
    int seatId;
    SeatCategory seatCategory;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
