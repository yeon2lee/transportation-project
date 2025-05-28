package refactor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long accountNumber = 1L;
        Long passengerNumber = 1L;
        Long transportNumber = 1L;

        List<Passenger> passengers = new ArrayList<>();
        List<Transport> transports = new ArrayList<>();

        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 고객 생성");
            System.out.println("2. 이동수단 생성");
            System.out.println("3. 고객 탑승");
            System.out.println("4. 고객 하차");
            System.out.println("5. 요약 보기");
            System.out.println("0. 종료");

            int choice = sc.nextInt();
            sc.nextLine(); // 개행 제거

            switch (choice) {
                case 1:
                    System.out.print("입금할 금액 입력: ");
                    long amount = sc.nextLong();
                    Account account = new Account(accountNumber++, amount);
                    Passenger passenger = new DefaultPassenger(passengerNumber++, 20, account);
                    passengers.add(passenger);
                    System.out.println("고객 생성 완료!");
                    break;

                case 2:
                    System.out.print("이동수단 종류 선택 (1. 버스, 2. 지하철): ");
                    int type = sc.nextInt();
                    System.out.print("요금 입력: ");
                    int fare = sc.nextInt();
                    Transport transport;
                    if (type == 1) {
                        transport = new Bus(transportNumber++, fare);
                    } else {
                        transport = new Subway(transportNumber++, fare);
                    }
                    transports.add(transport);
                    System.out.println("이동수단 생성 완료!");
                    break;

                case 3:
                    if (passengers.isEmpty() || transports.isEmpty()) {
                        System.out.println("고객 또는 이동수단이 존재하지 않습니다.");
                        break;
                    }

                    showPassengers(passengers);
                    System.out.print("탑승할 고객 번호 선택: ");
                    long pNum = sc.nextLong();

                    showTransports(transports);
                    System.out.print("이동수단 번호 선택: ");
                    long tNum = sc.nextLong();

                    Passenger boardingPassenger = findPassengerById(passengers, pNum);
                    Transport rideTransport = findTransportById(transports, tNum);

                    if (boardingPassenger != null && rideTransport != null) {
                        rideTransport.getOn(boardingPassenger);
                    } else {
                        System.out.println("해당 승객 또는 이동수단이 없습니다.");
                    }
                    break;

                case 4:
                    showTransports(transports);
                    System.out.print("하차할 이동수단 번호 선택: ");
                    long tNum2 = sc.nextLong();

                    Transport transportToLeave = findTransportById(transports, tNum2);
                    if (transportToLeave == null) {
                        System.out.println("해당 이동수단이 없습니다.");
                        break;
                    }

                    showPassengers(passengers);
                    System.out.print("하차할 고객 번호 선택: ");
                    long pNum2 = sc.nextLong();
                    Passenger exitingPassenger = findPassengerById(passengers, pNum2);

                    transportToLeave.getOff(exitingPassenger);
                    break;

                case 5:
                    System.out.println("\n[요약]");
                    for (Transport tr : transports) {
                        System.out.println(tr.getSummary());
                    }
                    break;

                case 0:
                    System.out.println("시뮬레이션 종료");
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void showPassengers(List<Passenger> passengers) {
        System.out.println("\n[고객 목록]");
        for (Passenger p : passengers) {
            System.out.println("고객 번호: " + p.getId() + ", 잔액: " + p.getAccount().getBalance());
        }
    }

    private static void showTransports(List<Transport> transports) {
        System.out.println("\n[이동수단 목록]");
        for (Transport t : transports) {
            System.out.println("이동수단 번호: " + t.getId() + ", 타입: " + t.getType() + ", 요금: " + t.getFare());
        }
    }

    private static Passenger findPassengerById(List<Passenger> passengers, long id) {
        for (Passenger p : passengers) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private static Transport findTransportById(List<Transport> transports, long id) {
        for (Transport t : transports) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}
