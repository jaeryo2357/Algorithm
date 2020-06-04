package backjun;

import java.util.Scanner;

public class q2447 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char[][] stars = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stars[i][j] = ' ';
            }
        }


        star(n, 0, 0, stars);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(stars[i][j]);
            }
            if (i + 1 >= n) {
                break;
            }
            builder.append("\n");
        }

        System.out.print(builder.toString());
    }

    public static void star(int n, int i, int j, char[][] stars) {

        if (n == 1) {
            if (i % 3 == 1 && j % 3 == 1) {
                stars[i][j] = ' ';
            } else {
                stars[i][j] = '*';
            }
            return;
        }
        int temp = n / 3;
        for (int h = 0; h < 3; h++) {
            for (int w = 0; w < 3; w++) {
                if (h % 3 == 1 && w % 3 == 1) {
                    continue;
                }
                star(temp, i + temp * w, j + h * temp, stars);
            }
        }
    }
}
