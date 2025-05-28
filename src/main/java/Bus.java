import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bus implements Transport {

    private long id;
    private long money;
    private long revenue;
    private long count;

    public Bus(long id, long money) {
        this.id = id;
        this.money = money;
        this.revenue = 0;
        this.count = 0;
    }

    public void getOn() {
        count++;
        revenue += money;
    }

    public void getOff() {
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

}
