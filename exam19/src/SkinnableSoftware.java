// 색상 변경이 가능한 소프트웨어 SkinnableSoftware 클래스
public class SkinnableSoftware implements Skinnable {
    int skin;     // 스킨

    // 생성자
    public SkinnableSoftware() {this.skin = BLACK;}
    public SkinnableSoftware(int skin) {this.skin = skin;}

    public void changeSkin(int skin) {this.skin = skin;}  // ★스킨 변경
    public int getSkin() {return skin;}                   // 스킨 가져오기
    public String getSkinString() {                       // 스킨의 문자열 반환
        switch (skin) {
            case BLACK: return "BLACK";
            case RED:   return "RED";
            case GREEN: return "GREEN";
            case BLUE:  return "BLUE";
            case YELLOW:return "YELLOW";
        }
        return "";
    }
}
