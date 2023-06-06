package backjun;

import java.util.Scanner;
import java.util.Arrays;

public class q2108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        int answer = 0;
        int max  = -4001;
        int min = 4001;

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            answer += numbers[i];

            if (max < numbers[i]) {
                max = numbers[i];
            }
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        //산술평균
        System.out.printf("%.0f\n", answer/ (double) n);

        Arrays.sort(numbers);

        //중앙값
        System.out.println(numbers[n / 2]);


        int[] count = new int[max - min + 1];

        for (int i = 0; i < n; i++) {
            count[numbers[i] - min]++;
        }

        int maxTemp = -4001;
        boolean second = false;

        for (int i = 0; i < count.length; i++) {
            int value = count[i];
            if (maxTemp < value) {
                answer = min + i;
                maxTemp = value;
                second = false;
            } else if (maxTemp == value && !second) {
                answer = min + i;
                second = true;
            }
        }

        //최빈값
        System.out.println(answer);

        //최댓값 최솟값 차이
        System.out.println(max - min);
    }
}
