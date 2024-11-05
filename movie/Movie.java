package movie;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

public class Movie {
    public static Movie findById(String movieIdStr) throws IOException {
        Movie movie = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line= null;

        //행 단위 문자열 읽기, 동작반복
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");  // 문자열을 쉼표로 나눔
            if (movieIdStr.equals(temp[0])) {
                //영화의 대표값을 찾으면 객체 생성
                movie = new Movie(Long.parseLong(temp[0]), temp[1], temp[2]);
                break;  //반복문 탈출(더 이상 찾지 않음)
            }
        }
        br.close();   //입력 흐름 해제
        return movie; //영화 객체 반환
    }

    //게터 메소드, 영화 제목을 반환
    public String getTitle() {
        return title;
    }

    public static void delete(String movieIdStr) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        // 파일 복사를 위한 빈 문자열
        String text = "";
        String line = null;

        //파일을 행 단위로 읽어옴 (반복)
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");  //쉼표 기준으로 문자열을 나눔
            if (movieIdStr.equals(temp[0])) {  //삭제 대상값을 찾으면
                continue;  // 다음 반복으로 넘어감(복사되지 않게)
            }
            text += line + "\n";   // 읽은 문자열을 누적하여 복사
        }
        br.close();   //입력 흐름 해제

        FileWriter fw = new FileWriter(file);    //FileWriter객체 생성(덮어쓰기 모드)
        fw.write(text);   //파일 출력
        fw.close();    //출력 흐름 해제
    }

    public Movie(String title, String genre) {   //생성자
        this.id = Instant.now().getEpochSecond();  // 타임스탬프
        this.title = title;
        this.genre = genre;
    }

    public void save() throws IOException {
        //FileWriter의 이어쓰기 모드를 true로 설정했기 때문에 파일출력은 맨 마지막 줄 끝에 작성된다.
        FileWriter fw = new FileWriter(file, true); // 이어쓰기(append) 모드 설정(true)
        fw.write(this.toFileString() + "\n");
        fw.close();
    }
    //영화 객체의 정보를 파일 출력 형식으로 변환
    private String toFileString() {  //객체 정보를 문자열로 반환
        return String.format("%d,%s,%s", id, title, genre);    // 영화 대푯값, 제목, 장르를 쉼표로 구분하는 문자열
    }
    //필드
    private long id; // 영화 대표값
    private String title; // 영화 제목
    private String genre; // 영화 장르
    private static final File file = new File("movies.txt");  // movies.txt파일 객체(파일 경로를 가리키는 객체를 생성)

    public Movie(long id, String title, String genre) {   // 생성자
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    //입출력 예외 발생 시, 호출 위치로 전달
    public static ArrayList<Movie> findAll() throws IOException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = br.readLine()) != null) {  //파일을 한 행씩 읽어와 반복
            String[] temp = line.split(","); //쉼표 기준으로 문자열을 나눔
            Movie m = new Movie(                  //여오하 객체 생성
                    Long.parseLong(temp[0]),      //영화 대표값
                    temp[1],        // 영화 제목
                    temp[2]         // 영화 장르
            );
            movies.add(m);   // 생성 영화 객체를 ArrayList에 추가
    }
        br.close();    //파일 입력 흐름 해제
        return movies; //영화 객체가 담긴 ArrayList반환
}

public String toString() {
        return String.format("[%d]: %s(%s)", id, title, genre);
    }
}
