import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 초기화 값
        Scanner sc = new Scanner(System.in);
        Long accountNumber = 1L;
        Long passengerNumber = 1L;
        List<Passenger> passengers = new ArrayList<>();

        //승객 생성 및 계좌 생성
        while (true) {
            System.out.println("입금할 금액을 입력해주세요. -1을 입력하면 종료");
            long amount = sc.nextLong();
            if (amount == -1) {
                break;
            }

            Account account = new Account(accountNumber++, amount);
            Passenger passenger = new Passenger(passengerNumber++, 20, account, new ArrayList<>());
            passengers.add(passenger);
        }

        // 생성된 승객 확인
        for (Passenger passenger : passengers) {
            passenger.printInfo();
        }


        // 대중교통 수단 생성





    }
}
