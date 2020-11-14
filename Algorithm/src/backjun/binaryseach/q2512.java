package backjun.binaryseach;

import java.util.Scanner;

public class q2512 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] request = new int[n];
        int allRequest = 0;
        int maxMoney= 0;
        for (int i = 0; i < n; i++) {
            request[i] = scanner.nextInt();
            allRequest += request[i];
            maxMoney = Math.max(maxMoney, request[i]);
        }

        int allMoney = scanner.nextInt();

        int answer = maxMoney;
        int minMoney = 1;

        if (allMoney < allRequest) {
           while (minMoney <= maxMoney) {
               int middleMoney = (maxMoney + minMoney) / 2;

               allRequest = 0;
               for (int i = 0; i < n; i++) {
                       allRequest += Math.min(middleMoney, request[i]);
               }

               if (allRequest <= allMoney) {
                   answer = middleMoney;
                   minMoney = middleMoney + 1;
               } else {
                   maxMoney = middleMoney - 1;
               }
           }
        }

        System.out.println(answer);
    }
}
