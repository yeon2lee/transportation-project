import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Subway implements Transport {

    private long id;
    private long money;
    private long revenue;
    private long count;
    private List<Passenger> passengers = new ArrayList<>();

    public Subway(long id, long money) {
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
        passengers.remove(passenger);
        if (count > 0) {
            count--;
        }
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
