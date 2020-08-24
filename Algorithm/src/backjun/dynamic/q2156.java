package backjun.dynamic;

import java.util.Scanner;

public class q2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] saveValue = new int[n + 1][2];
        int[] wines = new int[n];

        for (int index = 0; index < n; index++) {
            wines[index] = scanner.nextInt();
        }

        System.out.println(getMaxWine(0,0, wines, saveValue ));
    }

    public static int getMaxWine(int index, int time, int[] wine, int[][] saveValue) {
       if (index >= wine.length) {
           return 0;
       } else if (saveValue[index][time] != 0){
           return saveValue[index][time];
       } else {

           int max = 0;
           int temp;
           //현재 잔을 안마실 경우
           temp = getMaxWine(index + 1, 0, wine, saveValue);
           max = Math.max(max, temp);

           if (time == 0) {
               temp = wine[index] + getMaxWine(index + 1, 1, wine, saveValue);
               max = Math.max(max, temp);
           }

           for (int nextIndex = index + 3 - time; nextIndex < wine.length; nextIndex++) {
                temp = wine[index] + getMaxWine(nextIndex, 0, wine, saveValue);
                max = Math.max(max, temp);
           }

           max = Math.max(max, wine[index]);

           saveValue[index][time] = max;
           return saveValue[index][time];
       }
    }
}
