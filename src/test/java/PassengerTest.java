import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    private Passenger passenger;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1L, 10000L); // 초기 금액 10,000
        passenger = new Passenger(1L, 25, account, new ArrayList<>());
    }

    @Test
    void testPassengerCreation() {
        assertEquals(1L, passenger.getAccount().getAmount() / 10000);
        assertEquals(10000L, passenger.getAccount().getAmount());
    }

    @Test
    void testAccountDeposit() {
        passenger.getAccount().deposit(5000);
        assertEquals(15000L, passenger.getAccount().getAmount());
    }

    @Test
    void testAccountWithdrawSuccess() {
        boolean success = passenger.getAccount().withdraw(7000);
        assertTrue(success);
        assertEquals(3000L, passenger.getAccount().getAmount());
    }

    @Test
    void testAccountWithdrawFail() {
        boolean success = passenger.getAccount().withdraw(15000);
        assertFalse(success);
        assertEquals(10000L, passenger.getAccount().getAmount());
    }
}
