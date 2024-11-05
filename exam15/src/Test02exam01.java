public class Test02exam01 {
    public static void main(String[] args) {
        Test02 a = new Test02();        // 식별 번호 1번
        Test02 b = new Test02();        // 식별 번호 2번

        System.out.println("a의 식별 번호:" + a.getId());
        System.out.println("b의 식별 번호:" + b.getId());

        System.out.println("마지막으로 부여한 식별 번호 = " + Test02.getMaxId());
        System.out.println("마지막으로 부여한 식별 번호 = " + a.getMaxId());
        System.out.println("마지막으로 부여한 식별 번호 = " + b.getMaxId());
    }
}
