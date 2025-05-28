import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    private List<Object> transports;
    private int transportNumber;

    @BeforeEach
    void setUp() {
        transports = new ArrayList<>();
        transportNumber = 1;
        System.out.println("=== 테스트 시작 ===");
    }

    @Test
    @DisplayName("버스 객체 생성 및 추가 테스트")
    void testBusCreation() {
        System.out.println("🚌 버스 생성 테스트 시작");

        // Given
        int amount = 1500;

        // When
        Bus bus = new Bus(transportNumber++, amount);
        transports.add(bus);

        // Then
        assertNotNull(bus, "버스 객체가 null이 아니어야 함");
        assertEquals(1, transports.size(), "리스트에 버스가 추가되어야 함");
        assertTrue(transports.contains(bus), "리스트에 생성된 버스가 포함되어야 함");

        System.out.println("✅ 버스 생성 완료 - ID: " + (transportNumber-1) + ", 요금: " + amount + "원");
        System.out.println("현재 교통수단 개수: " + transports.size());
    }

    @Test
    @DisplayName("지하철 객체 생성 및 추가 테스트")
    void testSubwayCreation() {
        System.out.println("🚇 지하철 생성 테스트 시작");

        // Given
        int amount = 1800;

        // When
        Subway subway = new Subway(transportNumber++, amount);
        transports.add(subway);

        // Then
        assertNotNull(subway, "지하철 객체가 null이 아니어야 함");
        assertEquals(1, transports.size(), "리스트에 지하철이 추가되어야 함");
        assertTrue(transports.contains(subway), "리스트에 생성된 지하철이 포함되어야 함");

        System.out.println("✅ 지하철 생성 완료 - ID: " + (transportNumber-1) + ", 요금: " + amount + "원");
        System.out.println("현재 교통수단 개수: " + transports.size());
    }

    @Test
    @DisplayName("버스와 지하철 모두 생성 테스트")
    void testMultipleTransportCreation() {
        System.out.println("🚌🚇 복합 교통수단 생성 테스트 시작");

        // Given
        int busAmount = 1500;
        int subwayAmount = 1800;

        // When
        Bus bus = new Bus(transportNumber++, busAmount);
        transports.add(bus);
        System.out.println("버스 추가됨 - ID: " + (transportNumber-1) + ", 요금: " + busAmount + "원");

        Subway subway = new Subway(transportNumber++, subwayAmount);
        transports.add(subway);
        System.out.println("지하철 추가됨 - ID: " + (transportNumber-1) + ", 요금: " + subwayAmount + "원");

        // Then
        assertEquals(2, transports.size(), "리스트에 2개의 교통수단이 있어야 함");
        assertTrue(transports.contains(bus), "버스가 포함되어야 함");
        assertTrue(transports.contains(subway), "지하철이 포함되어야 함");

        System.out.println("✅ 총 교통수단 개수: " + transports.size());
        System.out.println("교통수단 리스트: " + transports);
    }

    @Test
    @DisplayName("교통수단 번호 증가 테스트")
    void testTransportNumberIncrement() {
        System.out.println("🔢 교통수단 번호 증가 테스트 시작");

        // Given
        int initialNumber = transportNumber;

        // When
        Bus bus1 = new Bus(transportNumber++, 1500);
        Bus bus2 = new Bus(transportNumber++, 1600);
        Subway subway1 = new Subway(transportNumber++, 1800);

        // Then
        assertEquals(initialNumber + 3, transportNumber, "번호가 3만큼 증가해야 함");

        System.out.println("초기 번호: " + initialNumber);
        System.out.println("현재 번호: " + transportNumber);
        System.out.println("✅ 번호 증가 확인 완료");
    }

    @Test
    @DisplayName("대량 교통수단 생성 성능 테스트")
    void testLargeScaleCreation() {
        System.out.println("⚡ 대량 생성 성능 테스트 시작");

        long startTime = System.currentTimeMillis();

        // When
        for(int i = 0; i < 1000; i++) {
            if(i % 2 == 0) {
                Bus bus = new Bus(transportNumber++, 1500);
                transports.add(bus);
            } else {
                Subway subway = new Subway(transportNumber++, 1800);
                transports.add(subway);
            }
        }

        long endTime = System.currentTimeMillis();

        // Then
        assertEquals(1000, transports.size(), "1000개의 교통수단이 생성되어야 함");

        System.out.println("✅ 1000개 교통수단 생성 완료");
        System.out.println("소요시간: " + (endTime - startTime) + "ms");
        System.out.println("버스 개수: " + transports.stream().filter(t -> t instanceof Bus).count());
        System.out.println("지하철 개수: " + transports.stream().filter(t -> t instanceof Subway).count());
    }
}
