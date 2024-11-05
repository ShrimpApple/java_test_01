package movie;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {

    private static final AdminMenu instance = new AdminMenu(null); // 자기 자신의 객체 생성

    private static final String ADMIN_MENU_TEXT = // 기본문구
                        "1: 영화 등록하기 \n" +
                                "2: 영화 목록보기 \n" +
                                "3: 영화 삭제하기 \n" +
                                "b: 메인메뉴로 이동 \n\n" +
                                "메뉴를 선택하세요.";

    // private 생성자 (외부에서 객체 생성 불가)
    private AdminMenu(Menu prevMenu) {
        super(ADMIN_MENU_TEXT, prevMenu);  // 부모 생성자 ㅎ ㅗ 출
    }

    public static AdminMenu getInstance() {
        return instance; // 메뉴 객체를 반환
    }

    public Menu next() {
        switch (scanner.nextLine()) {
            case "1":
                createMovie(); // 영화 등록 진행
                return this; // 관리자 메뉴 객체 반환

            case "2": // 2번 메뉴 선택시
                printAllMovies(); // 영화 목록 출력
                return this; // 관리자 메뉴 객체 반환

            //3번 선택지를 추가하고 다시 관리자 메뉴로 돌아온다. 영화삭제가 진행
            case "3":
                deleteMovie();   //영화 삭제 진행
                return this;     // 관리자 메뉴 객체 반환(다시 관리자 메뉴가 나옴)

            case "b":
                // 사용자 입력이 b인 경우 prevMenu를 반환,
                // prevMenu의 초기값은 null이지만 실행중 세터에 의해 값이 바뀔수 있음
                return prevMenu; // b 입력시, 이전 메뉴를 전환
            default:
                return this;
        }
    }

    private void deleteMovie() {
        printAllMovies();   //모든 영화를 출력
        System.out.println("삭제할 영화를 선택하세요.");

        //삭제 중 발생한 예외는 try-catch문으로 처리
        try {
            Movie.delete(scanner.nextLine());  // 사용자 입력값 기준으로 삭제요청
            System.out.println(">>삭제 되었습니다.");
        } catch (IOException e) {
            System.out.println(">>삭제에 실패하였습니다.");
        }
    }

    private void createMovie() {
        System.out.println("제목");
        String title = scanner.nextLine(); // 제목 입력

        System.out.println("장르");  // 장르 입력
        String genre = scanner.nextLine(); // 제목 입력
        Movie movie = new Movie(title, genre); // 영화 객체 생성

        try {
            movie.save();  // 영화 객체를 저장
            System.out.println(">>등록되었습니다.");
        } catch (IOException e) {  //예외처리
            System.out.println(">>실패하였습니다.");
        }
    }

    private void printAllMovies() {
        try {
            ArrayList<Movie> movies = Movie.findAll();  // 모든 영화를 가져옴
            System.out.println();
            for (int i = 0; i < movies.size(); i++) {
                System.out.printf("%s\n", movies.get(i).toString());  // 출력
            }
        } catch (IOException e) {
            System.out.println("데이터 접근에 실패하였습니다.");  // 예외처리
        }
    }
}
