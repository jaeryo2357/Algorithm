package backjun;

import java.util.Scanner;

public class q1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] rgb = new int[n][3];

        // 패턴마다 최솟값
        int[][] info = new int[n][3];
        int[] savePattern = new int[n];

        for (int index = 0; index < n; index++) {
            rgb[index][0] = scanner.nextInt();
            rgb[index][1] = scanner.nextInt();
            rgb[index][2] = scanner.nextInt();

            savePattern[index] = -1;
        }

        System.out.println(drawColor( 0, rgb, info, savePattern));
    }

    public static int drawColor(int index, int[][] rgb, int[][] info, int[] savePattern) {
        if (index >= savePattern.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int pattern = 0; pattern < 3; pattern++) {
                if (pattern != savePattern[getRange(index - 1, savePattern.length)] && pattern != savePattern[getRange(index + 1, savePattern.length)]) {
                    savePattern[index] = pattern;
                    int temp;
                    if (info[index][pattern] != 0) {
                        temp = rgb[index][pattern] + info[index][pattern];
                    } else {
                        info[index][pattern] = drawColor(index + 1, rgb, info, savePattern);
                        temp = rgb[index][pattern] + info[index][pattern];
                    }
                    savePattern[index] = -1;

                    if (min > temp) {
                        min = temp;
                    }

                }
        }

        return min;
    }

    public static int getRange(int index, int maxLength) {
        if (index < 0) return  0;
        else if (index >= maxLength) return index - 1;
        else return index;
    }
}
