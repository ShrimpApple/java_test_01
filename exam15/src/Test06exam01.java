import java.util.Scanner;

public class Test06exam01 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("x값 : "); int x = stdIn.nextInt();
        System.out.print("y값 : "); int y = stdIn.nextInt();
        System.out.print("z값 : "); int z = stdIn.nextInt();
        System.out.println("배열a의 요소 수:");
        int num = stdIn.nextInt();
        int[] a = new int[num];         // 요소 수가 num인 배열
        for (int i = 0; i < num; i++) {
            System.out.print("a[" + i + "]:");
            a[i] = stdIn.nextInt();
        }

        System.out.printf("x, y의 최솟값은 %d입니다.\n", Test06.min(x, y));
        System.out.printf("x, y의 최댓값은 %d입니다.\n", Test06.max(x, y));
        System.out.printf("x, y, z의 최솟값은 %d입니다.\n", Test06.min(x, y, z));
        System.out.printf("x, y, z의 최댓값은 %d입니다.\n", Test06.max(x, y, z));
        System.out.printf("배열 a의 최솟값은 %d입니다.\n", Test06.min(a));

        int xmin[] = Test06.minIndexArray(a);
        System.out.print("인덱스는{ ");
        for (int i = 0; i < xmin.length; i++)
            System.out.print(xmin[i] + " "); System.out.println("}입니다.");
        System.out.printf("배열 a의 최댓값은 %d입니다.\n", Test06.max(a));
        int xmax[] = Test06.maxIndexArray(a);
        System.out.print("인덱스는 { ");
        for (int i = 0; i < xmax.length; i++)
            System.out.print(xmax[i] + " ");
        System.out.println("}입니다.");
    }
}
