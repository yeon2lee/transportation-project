package refactor;

public class DefaultPassenger implements Passenger {
    private Long id;
    private int age;
    private Account account;

    public DefaultPassenger(Long id, int age, Account account) {
        this.id = id;
        this.age = age;
        this.account = account;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public boolean payFare(int fare) {
        return account.withdraw(fare);
    }
}