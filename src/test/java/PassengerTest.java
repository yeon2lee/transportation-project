import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    private Passenger passenger;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1L, 10000L); // 초기 금액 10,000원
        passenger = new Passenger(1L, 25, account, new ArrayList<>());
    }

    @Test
    @DisplayName("승객 생성 시 계좌 금액이 정상적으로 저장되어야 한다")
    void testPassengerCreation() {
        assertEquals(10000L, passenger.getAccount().getAmount());
    }

    @Test
    @DisplayName("계좌에 입금하면 금액이 증가해야 한다")
    void testAccountDeposit() {
        passenger.getAccount().deposit(5000);
        assertEquals(15000L, passenger.getAccount().getAmount());
    }

    @Test
    @DisplayName("계좌에서 출금 가능한 금액이면 출금에 성공하고 잔액이 줄어야 한다")
    void testAccountWithdrawSuccess() {
        boolean success = passenger.getAccount().withdraw(7000);
        assertTrue(success);
        assertEquals(3000L, passenger.getAccount().getAmount());
    }

    @Test
    @DisplayName("계좌에서 출금 불가능한 금액이면 출금에 실패하고 잔액은 유지되어야 한다")
    void testAccountWithdrawFail() {
        boolean success = passenger.getAccount().withdraw(15000);
        assertFalse(success);
        assertEquals(10000L, passenger.getAccount().getAmount());
    }
}