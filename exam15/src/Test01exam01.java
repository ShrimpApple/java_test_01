public class Test01exam01 {
    public static void main(String[] args) {
        Test01 a = new Test01();              // 식별 번호 1번
        Test01 b = new Test01();              // 식별 번호 2번

        System.out.println("a의 식별 번호:" + a.getId());
        System.out.println("b의 식별 번호:" + b.getId());

        System.out.println("Id.counter = " + Test01.counter);
        System.out.println("a.counter = " + a.counter);
        System.out.println("b.counter = " + b.counter);
    }
}
