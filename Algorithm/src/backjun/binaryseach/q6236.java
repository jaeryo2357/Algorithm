package backjun.binaryseach;

import java.util.Scanner;

public class q6236 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] days = new int[n];
        int minMoney = 0;
        int maxMoney = 0;
        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
            maxMoney += days[i];
            minMoney = Math.max(minMoney, days[i]);
        }
        int answer = 0;

        while (minMoney <= maxMoney) {
            int middleMoney = (maxMoney + minMoney) / 2;

            int count = 0;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (temp < days[i]) {
                    count++;
                    temp = middleMoney - days[i];
                } else {
                    temp -= days[i];
                }
            }

            if (count <= m) {
                answer = middleMoney;
                maxMoney = middleMoney - 1;
            } else {
                minMoney = middleMoney + 1;
            }
        }

        System.out.println(answer);

    }
}
