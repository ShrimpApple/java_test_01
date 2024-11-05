public class Test01exam02 {
    public static void main(String[] args) {
        Test01exam01 myTest = new Test01exam01("W221",
                1845, 1490, 5205,
                90.0,
                new Day(2015,12,24));
        System.out.printf("현재위치:  (%.2f,%.2f)\n", myTest.getX(), myTest.getY());
        System.out.printf("남은연료:%.2f리터\n",myTest.getFuel());
        System.out.printf("구 입 일:%s\n", myTest.getPurchaseDay());
    }
}
