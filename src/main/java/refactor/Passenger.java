package refactor;

public interface Passenger {
    Long getId();
    int getAge();
    Account getAccount();
    boolean payFare(int fare);
}