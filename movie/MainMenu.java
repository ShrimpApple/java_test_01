package movie;

import java.io.IOException;
import java.util.ArrayList;

//AbstractMenu를 상속받음
class MainMenu extends AbstractMenu {
    private static final MainMenu instance = new MainMenu(null); // 자기 자신의 객체 생성
    private static final String MAIN_MENU_TEXT = // 기본문구
            "1 : 영화 예매하기 \n" +
                    "2 : 예매 확인하기 \n" +
                    "3 : 예매 취소하기 \n" +
                    "4 : 관리자 메뉴로 이동 \n" +
                    "q : 종료\n\n" +
                    "메뉴를 선택하세요.";

    // private 생성자(외부에서 객체 생성 불가), 싱글턴패턴(단 하나의 객체 생성)
    private MainMenu(Menu prevMenu) {
        super(MAIN_MENU_TEXT, prevMenu); // 부모 생성자 호출
    }

    public static MainMenu getInstance() {
        return instance; // 메뉴객체 반환
    }


    public Menu next() {
        switch (scanner.nextLine()) { // 사용자 입력을 행 단위로 가져옴
            case "1":
                reserve(); // 영화예매를 진행
                return this; //메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)
            // 2번 선택지를 추가하고 다시 메인 메뉴로 돌아온다.
            case "2":
                checkReservation(); //예매확인 진행
                return this; // 메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)

            case "3":
                cancelReservation();  //예매취소 진행
                return this; // 메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)

            case "4":
                if (!checkAdminPassword()) { //관리자 비밀번호
                    System.out.println(">>비밀번호가 틀렸습니다.");
                    return this; // 실패한 경우 메인 메뉴 객체 반환
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this); // 메인 메뉴를 이전 메뉴로 등록
                return adminMenu; // 관리자 메뉴 객체 반환

            case "q":
                //q입력시 prevMenu가 null 이므로 프로그램 종료, 그 외 입력은 자기 자신을 반환
                return prevMenu; // q 입력시, prvMenu를 반환
            default:
                return this; // 그 외 입력은 메인 메뉴(this)로 돌아감
        }
    }

    private void reserve() {
        try {
            //영화목록 출력
            ArrayList<Movie> movies = Movie.findAll();
            for (int i = 0; i < movies.size(); i++) {
                System.out.printf("%s\n", movies.get(i).toString());
            }

            //예매영화선택
            System.out.print("예매할 영화를 선택하세요:");
            String movieIdStr = scanner.nextLine();
            Movie m = Movie.findById(movieIdStr);

            //예매 영화의 좌석 현황 출력
            ArrayList<Reservation> reservations = Reservation.findByMovieId(movieIdStr);
            Seats seats = new Seats(reservations);
            seats.show();

            //예매 좌석 선택
            System.out.print("좌석을 선택하세요.(예:E-9):");
            String seatName = scanner.nextLine();
            seats.mark(seatName);

            //예매 객체 저장
            Reservation r = new Reservation(
                    Long.parseLong(movieIdStr),  //영화 대표값
                    m.getTitle(),  //영화제목
                    seatName);       //좌석명
                    r.save();

            //예매 완료 결과 출력
            System.out.println(">>예매가 완료되었습니다.");
            System.out.printf(">> 발급번호: %d\n", r.getId());
        } catch (IOException e) {
            System.out.println(">>파일 입출력에 문제가 생겼습니다.");
        } catch (Exception e) {
            System.out.printf(">>예매에 실패하였습니다: %s\n", e.getMessage());
        }
    }

        private void cancelReservation () {
            System.out.print("발급번호를 입력하세요.");
            try {
                Reservation canceled = Reservation.cancel(scanner.nextLine());
                if (canceled != null) {
                    System.out.printf(">>[취소 완료] %s의 예매가 취소되었습니다.\n",
                            canceled.toString());
                } else {
                    System.out.println(">> 예매 내역이 없습니다.");
                }
            } catch (IOException e) {
                System.out.println(">>파일 입출력에 문제가 생겼습니다.");
            }
        }


        private void checkReservation () {
            System.out.println("발급번호를 입력하세요.");
            try {
                Reservation r = Reservation.findById(scanner.nextLine());  // 예매확인

                if (r != null) {
                    System.out.printf(">>[확인 완료] %s\n", r.toString());
                } else {
                    System.out.println(">> 예매 내역이 없습니다.");
                }

            } catch (IOException e) {
                System.out.println(">>파일 입출력에 문제가 생겼습니다.");
            }
        }


    private boolean checkAdminPassword() {
        System.out.print("관리자 비밀번호를 입력하세요 : ");
        return "admin1234".equals(scanner.nextLine()); // 관리자비밀번호(admin1234), 비교할 사용자 입력값
    }
}
