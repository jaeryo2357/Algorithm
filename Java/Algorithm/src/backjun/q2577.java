package backjun;

import java.util.Scanner;

public class q2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int total = a * b * c;

        while (total / 10 != 0) { //10 이상
            int placeOfOne = total % 10;

            num[placeOfOne]++;
            total = (total - placeOfOne) / 10;
        }

        if (total % 10 != 0) {
            num[total % 10]++;
        }

        for (int time : num) {
            System.out.println(time);
        }
    }
}
