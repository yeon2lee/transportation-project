public interface Transport{

    long id = 0;
    long money = 0;

    void getOn();
    void getOff();
    long calculateRevenue();
    long calculateCount();
}