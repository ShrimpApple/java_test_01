// 자동차 클래스(총 주행 거리) 사용 예(사양 표시)
public class Test01exam03 {
    public static void main(String[] args) {
        Test01exam01 myCar = new Test01exam01("W221", 1845, 1490, 5205, 90.0,
                new Day(2015,12,24));
        myCar.putSpec();    // 사양 표시
    }
}
