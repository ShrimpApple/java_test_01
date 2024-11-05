public class Test02 {
    public static void main(String[] args) {
        Test01 test01 = new Test01("W140", 1885, 1490, 5220,
                95.0,
                new Day(2018, 10,13));

        Test01exam01 test01exam01 = new Test01exam01("W221", 1845,1490,5205,
                90.0,
                new Day(2015, 12, 24));

        Test01 x;        // 클래스형 변수는 ...
        x = test01;      // 자기자신의 형 인스턴스를 참조할 수 있다(당연)
        x = test01exam01; // 하위 클래스형의 인스턴스도 참조할 수 있다!

        System.out.println("x구입일:" + x.getPurchaseDay());

        Test01exam01 y;    // 클래스형 변수는 ...
//        y = test01;        // 상위 클래스형의 인스턴스는 참조할 수 없다!
        y = test01exam01;  // 자기자신의 형 인스턴스는 참조할 수 있따(당연)

        System.out.println("y구입일:" + y.getPurchaseDay());
        System.out.println("y의 총 주행 거리:" + y.getTotalMileage());
    }
}
