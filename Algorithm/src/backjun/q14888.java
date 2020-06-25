package backjun;

import java.util.Scanner;

public class q14888 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] num = new int[n];
        int[] operator = new int[4];

        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        for (int i = 0; i < operator.length; i++) {
            operator[i] = scanner.nextInt();
        }

        System.out.println(findMaxValue(num[0], 1, num, operator));

        System.out.println(findMinValue(num[0], 1, num, operator));
    }

    public static long findMaxValue(long result, int numberIndex, int[] num, int[] operator) {

        if (numberIndex >= num.length) {
            return result;
        }

        long max = -1000000000;
        for (int p = 0; p < operator.length; p++) {
            if (operator[p] != 0) {
                operator[p]--;
                long resultValue = findMaxValue(operatorNum(num, result, numberIndex, p), numberIndex + 1, num, operator );
                if (max < resultValue) {
                    max = resultValue;
                }
                operator[p]++;
            }
        }

        return max;
    }

    public static long findMinValue(long result, int numberIndex, int[] num, int[] operator) {

        if (numberIndex >= num.length) {
            return result;
        }

        long min = 1000000000;
        for (int p = 0; p < operator.length; p++) {
            if (operator[p] != 0) {
                operator[p]--;
                long resultValue = findMinValue(operatorNum(num, result, numberIndex, p), numberIndex + 1, num, operator );
                if (min > resultValue) {
                    min = resultValue;
                }
                operator[p]++;
            }
        }

        return min;
    }

    public static long operatorNum(int[] num, long result, int numberIndex, int operatorIndex) {

        switch (operatorIndex) {
            case  0: //덧셈
                return result + num[numberIndex];

            case 1 : //뺄셈
                return result - num[numberIndex];

            case 2: //곱셈
                return result * num[numberIndex];

            default: //나눗셈
                return result / num[numberIndex];

        }
    }
}
