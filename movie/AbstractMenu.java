package movie;

import java.util.Scanner;

abstract class AbstractMenu implements Menu {  //메뉴 인터페이스를 구현
    protected String menuText; // 기본문구
    protected Menu prevMenu;   // 이전 메뉴
    protected static final Scanner scanner = new Scanner(System.in); //키보드 입력을 위한 객체 새엇ㅇ

    public AbstractMenu(String menuText, Menu prevMenu) { // 생성자
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    // Menu 인터페이스의 print()메소드를 재정의
    public void print() {
        System.out.println("\n" + menuText); // 메뉴출력
    }

    public void setPrevMenu(Menu prevMenu) { // 세터 메소드
        this.prevMenu = prevMenu;
         }
}
