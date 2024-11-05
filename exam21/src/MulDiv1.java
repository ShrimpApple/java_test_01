// 2개의 정숫값을 읽어서 곱과 몫 구하기
import java.util.Scanner;

public class MulDiv1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("x값: "); int x = stdIn.nextInt();
        System.out.print("y값: "); int y = stdIn.nextInt();

        System.out.println("x * y = " + (x * y));  // x * y값 표시(곱)
        System.out.println("x / y = " + (x / y));  // x / y값 표시(몫)
    }
}
