package refactor;

public interface Transport {
    Long getId();
    String getType();
    int getFare();
    int getPassengerCount();
    int getRevenue();

    void getOn(Passenger passenger);
    void getOff(Passenger passenger);

    default String getSummary() {
        return String.format("%s (%d번) - 수익: %d원, 탑승자 수: %d명",
                getType(), getId(), getRevenue(), getPassengerCount());
    }
}