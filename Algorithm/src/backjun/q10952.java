package backjun;

import java.util.Scanner;

public class q10952 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        while(true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            result = a + b;
            if (result == 0) break;
            System.out.println(result);
        }
    }
}
