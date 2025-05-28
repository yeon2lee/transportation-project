public interface Transport {
    void getOn(Passenger passenger);            // 승객 탑승
    void getOff(Passenger passenger);           // 승객 하차

    long calculateRevenue();                    // 수입 계산
    long calculateCount();                      // 현재 탑승자 수

    long getId();                               // 고유 ID
    String getType();                           // 이동수단 타입 (버스/지하철)
    long getMoney();                              // 요금
    String getSummary();                        // 요약 정보 출력용
}