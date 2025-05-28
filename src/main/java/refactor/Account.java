package refactor;

public class Account {
    private Long id;
    private long balance;

    public Account(Long id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public long getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }
}
