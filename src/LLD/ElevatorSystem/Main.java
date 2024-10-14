package LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request(1, 5));
        requests.add(new Request(2, 8));

        // Initialize elevators
        Elevator elevator1 = new Elevator(1, 5);
        Elevator elevator2 = new Elevator(2, 5);

        // Add requests to elevators
        elevator1.addRequest(requests.get(0));
        elevator2.addRequest(requests.get(1));

        // Process requests
        elevator1.move();
        elevator2.move();
    }
}
