// 일련 번호 클래스 (Ver.2)
public class Test02 {
    private static int counter = 0;  // 몇 번까지 식별 부여를 부여했는가
    private int id;                  // 식별 번호

    //--- 생성자 ---//
    public Test02() {
        id = ++counter;              // 식별 번호
    }

    //--- 식별 번호 가져오기 ---//

    public int getId() {return id;}

    //--- 마지막에 부여한 식별 번호 가져오기 ---//
    public static int getMaxId() {
        return counter;
    }
}
