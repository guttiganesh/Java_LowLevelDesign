package LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    List<Elevator> elevators;
    List<Request> requests;

    public ElevatorController(int noOfElevators, List<Request> requests) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= noOfElevators; i++) {
            elevators.add(new Elevator(i, 5)); // Example capacity of 5
        }
        this.requests = requests;
    }

    public void handleRequest(Request request) {
        Elevator bestElevator = findBestElevator(request);
        bestElevator.addRequest(request);
    }

    private Elevator findBestElevator(Request request) {
        Elevator bestElevator = null;
        for (Elevator elevator : elevators) {
            if (bestElevator == null ||
                    (elevator.getDirection() == request.getDirection() &&
                            Math.abs(elevator.getCurrentFloor() - request.getSourceFloor()) <
                                    Math.abs(bestElevator.getCurrentFloor() - request.getSourceFloor()))) {
                bestElevator = elevator;
            }
        }
        return bestElevator;
    }

    public void step() {
        for (Elevator elevator : elevators) elevator.move();
    }

    public void processRequests() {
        for (Request request : requests) {
            handleRequest(request);
        }
        // Process each elevator's requests
        for (Elevator elevator : elevators) elevator.move();
    }
}
