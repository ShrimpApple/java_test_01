package movie;

import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다.!"); // 프로그램 실행 문구
        Menu menu = MainMenu.getInstance(); // 메인 메뉴를 가져옴

        //메뉴가 없을 때까지 반복
        while (menu != null) {  //메뉴가 있으면 계속 반복
            menu.print();    //현재 메뉴 출력
            menu = menu.next();   //사용자 입력 후, 다음 메뉴로 갱신
        }
        System.out.println("프로그램이 종료됩니다.");  //프로그램 종료 문구
    }
}

interface Menu {
    void print(); //메뉴출력, 메뉴 객체가 어떤 내용을 화면에 출력해야 하는지를 나타내는 메서드
    Menu next(); //다음 메뉴로 이동, next의 반환 값이 Menu
}
