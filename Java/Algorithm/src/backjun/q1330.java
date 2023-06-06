package backjun;

import java.util.Scanner;

public class q1330 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String result;
        if (a > b) {
            result = ">";
        } else if (a < b) {
            result = "<";
        } else {
            result = "==";
        }
        System.out.println(result);
    }
}
