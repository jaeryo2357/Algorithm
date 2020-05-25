package backjun;

import java.util.Scanner;

public class q2753 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int result; //윤년

        if ( year % 400 == 0 ||year % 4 == 0 && year % 100 != 0 ) {
            result = 1;
        } else {
            result = 0;
        }

        System.out.println(result);
    }
}
