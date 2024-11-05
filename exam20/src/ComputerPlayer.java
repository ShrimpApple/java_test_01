// 가위바위보 컴퓨터 플레이어 클래스
import java.util.Random;

public class ComputerPlayer extends Player {
    private static Random rand;
    static {
        rand = new Random();
    }

    //--- 손 결정(난수를 통해 생성) ---//
    public int nextHand() {
        return rand.nextInt(3);
    }
}
