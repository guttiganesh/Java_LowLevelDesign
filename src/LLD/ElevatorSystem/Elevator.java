package LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int id;
    private final int capacity;
    private int currentFloor;
    private Direction currentDirection;
    private final List<Request> requests;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 1; // Default start floor
        this.currentDirection = Direction.IDLE;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request) {
        if (requests.size() < capacity) {
            requests.add(request);
            System.out.println("Elevator " + id + " added request: " + request);
        } else {
            System.out.println("Elevator " + id + " is at full capacity.");
        }
    }

    public synchronized void move() {
        if (requests.isEmpty()) {
            currentDirection = Direction.IDLE;
            return;
        }

        Request request = requests.get(0);

        if (currentFloor < request.getSourceFloor()) {
            currentDirection = Direction.UP;
            moveToFloor(request.getSourceFloor());
        } else if (currentFloor > request.getSourceFloor()) {
            currentDirection = Direction.DOWN;
            moveToFloor(request.getSourceFloor());
        }
        if (currentFloor == request.getSourceFloor()) {
            currentDirection = Direction.IDLE;
            System.out.println("Elevator " + id + " arrived at source floor " + currentFloor);
            processRequest(request);
            requests.remove(0);
        }
    }

    private void moveToFloor(int targetFloor) {
        if (targetFloor == currentFloor) return;
        int step = (targetFloor > currentFloor) ? 1 : -1;
        while (currentFloor != targetFloor) {
            currentFloor += step;
            System.out.println("Elevator " + id + " moved " + (step > 0 ? "UP" : "DOWN") + " to floor " + currentFloor);
        }
    }

    private void processRequest(Request request) {
        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();

        if (startFloor < endFloor) {
            currentDirection = Direction.UP;
            moveToFloor(endFloor);
        } else if (startFloor > endFloor) {
            currentDirection = Direction.DOWN;
            moveToFloor(endFloor);
        }

        System.out.println("Elevator " + id + " arrived at destination floor " + endFloor);
        currentDirection = Direction.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return currentDirection;
    }

    public void setDirection(Direction direction) {
        this.currentDirection = direction;
    }
}
