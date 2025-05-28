import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Passenger {

    private Long id;
    private int age;
    private Account account;
    private long fromId;
    private long toId;
    private List<Movement> rideHistory;

    public Passenger(Long id, int age, Account account, List<Movement> rideHistory) {
        this.id = id;
        this.age = age;
        this.account = account;
        this.rideHistory = rideHistory;
    }

    public void printInfo() {
        System.out.println("=== Passenger Information ===");
        System.out.println("ID        : " + id);
        System.out.println("Age       : " + age);
        System.out.println("Balance   : " + account.getAmount());
        System.out.println("==============================");
    }
}
