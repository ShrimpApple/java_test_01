// 가위바위보 플레이어를 나타내는 추상 클래스
public abstract class Player {
    int hand;                           // 손(0:가위/1:바위/2:보)
    public abstract int nextHand();     // 다음 손 결정
}
