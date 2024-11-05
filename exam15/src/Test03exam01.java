public class Test03exam01 {
    public static void main(String[] args) {
        Test03 a = new Test03();      // 식별 번호 1번
        Test03 b = new Test03();      // 식별 번호 2번
        Test03 c = new Test03();      // 식별 번호 3번
        Test03.setStep(4);
        Test03 d = new Test03();      // 식별 번호 7번
        Test03 e = new Test03();      // 식별 번호 11번
        Test03 f = new Test03();      // 식별 번호 15번

        System.out.println("a의 식별 번호:" + a.getId());
        System.out.println("b의 식별 번호:" + b.getId());
        System.out.println("c의 식별 번호:" + c.getId());
        System.out.println("d의 식별 번호:" + d.getId());
        System.out.println("e의 식별 번호:" + e.getId());
        System.out.println("f의 식별 번호:" + f.getId());

        int max = Test03.getMaxId();
        System.out.println("마지막에 부여한 식별 번호 = " + max);
        System.out.println("다음에 부여할 식별 번호 = " + (max + Test03.getStep()));
    }
}
