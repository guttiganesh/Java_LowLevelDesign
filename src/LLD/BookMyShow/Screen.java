package LLD.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int scrrenId;
    List<Seat> seats = new ArrayList<>();

    public int getScrrenId() {
        return scrrenId;
    }

    public void setScrrenId(int scrrenId) {
        this.scrrenId = scrrenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
