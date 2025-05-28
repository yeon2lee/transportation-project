import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bus implements Transport {

    private long id;
    private long money;
    private long revenue;
    private long count;
    private List<Passenger> passengers = new ArrayList<>();

    public Bus(long id, long money) {
        this.id = id;
        this.money = money;
        this.revenue = 0;
        this.count = 0;
    }

    public void getOn(Passenger passenger) {
        passengers.add(passenger);
        count++;
        revenue += money;
    }

    public void getOff(Passenger passenger) {
        if (count > 0) {
            count--;
        }
        passengers.remove(passenger);
    }

    public long calculateRevenue() {
        return revenue;
    }

    public long calculateCount() {
        return count;
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public String getSummary() {
        return "";
    }

}
