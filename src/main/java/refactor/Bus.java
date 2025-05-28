package refactor;

import java.util.HashSet;
import java.util.Set;

public class Bus implements Transport {
    private final Long id;
    private final int fare;
    private int revenue = 0;
    private final Set<Long> passengers = new HashSet<>();

    public Bus(Long id, int fare) {
        this.id = id;
        this.fare = fare;
    }

    @Override
    public void getOn(Passenger passenger) {
        if (passenger.payFare(fare)) {
            revenue += fare;
            passengers.add(passenger.getId());
        }
    }

    @Override
    public void getOff(Passenger passenger) {
        passengers.remove(passenger.getId());
    }

    @Override public Long getId() { return id; }
    @Override public String getType() { return "버스"; }
    @Override public int getFare() { return fare; }
    @Override public int getPassengerCount() { return passengers.size(); }
    @Override public int getRevenue() { return revenue; }
}
