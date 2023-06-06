package backjun;

import java.util.Scanner;

public class q1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int count = 1;
        int temp;

        do {
            temp = count * (count + 1) / 2;
            count++;
        } while (temp < x);

        count -= 1;
        temp -= 1 + (count - 1);

        int distance = x - temp - 1;

        if (count % 2 == 0) {
            System.out.printf("%d/%d",1 + distance, count - distance);
        } else {
            System.out.printf("%d/%d",count - distance, 1 + distance);
        }
    }
}
