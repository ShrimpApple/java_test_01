// 당첨 기능을 가진 2차원 좌표 클래스 Point2D
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test02 {
    private static int counter = 0;          // 몇 번까지 식별 번호를 부여했는가
    private static int day;                  // 오늘 날짜

    private int x = 0; // X좌표
    private int y = 0; // Y좌표

    //--- 클래스 초기화 블록 ---//
    static {
        GregorianCalendar today = new GregorianCalendar();   // 현재 날짜
        day = today.get(Calendar.DATE);  // today의일
    }

    //--- 인스턴스 초기화 블록 ---//
    {
        if (++counter == day) {
            System.out.print("당첨!!");
            System.out.printf("오늘 %d개의 좌표가 생성됐습니다.\n", counter);
        }
    }

    //--- 생성자 ---//
    public Test02() { }
    public Test02(int x) {this.x = x;}
    public Test02(int x, int y) {this.x = x; this.y = y;}

    public int getX() {return x;}   // X좌표의 게터
    public int getY() {return y;}   // Y좌표의 게터

    // 마지막에 부여한 식별 번호
    public static int getCounter() {return counter;}
    //--- 문자열 표현 "(x, y)"을 반환 ---//
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
public Test02() {
    if (++counter == day) {
        System.out.print("당첨!!");
        System.out.printf("오늘 %d개의 좌표가 생성됐습니다.\n", counter);
    }
}
public Test02(int x) {
    if (++counter == day) {
        System.out.print("당첨!!");
        System.out.printf("오늘 %d개의 좌표가 생성됐습니다.\n", counter);
    }
    this.x = x;
}
public Test02(int x, int y) {
    if (++counter == day) {
        System.out.print("당첨!!");
        System.out.printf("오늘 %d개의 좌표가 생성됐습니다.\n", counter);
    }
    this.x = x; this.y = y;
}


