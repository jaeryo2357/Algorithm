package backjun.bruteforce;

import java.util.Scanner;

public class q2503 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] check = new boolean[1000];
        int n = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] value = scanner.nextLine().split(" ");

            int[] numbers = new int[3];

            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = value[0].charAt(j) - '0';
            }

            for (int one = 1; one < 10; one++) {
                for (int two = 1; two < 10; two++) {
                    for (int three = 1; three < 10; three++) {
                        if ((one == two || two == three || three == one)) {
                            continue;
                        }

                        int index = Integer.parseInt("" + one + two + three);

                        if (check[index]) {
                            continue;
                        }

                        int strike = 0;
                        int ball = 0;

                        int[] checkNumber = new int[3];

                        checkNumber[0] = one;
                        checkNumber[1] = two;
                        checkNumber[2] = three;

                        for (int j = 0; j < 3; j++) {
                            for (int k = 0; k < 3; k++) {

                                if (j == k && checkNumber[j] == numbers[k]) {
                                    strike++;
                                }

                                if (j != k && checkNumber[j] == numbers[k]) {
                                    ball++;
                                }
                            }
                        }

                        if (strike != Integer.parseInt(value[1]) || ball != Integer.parseInt(value[2])) {
                            check[index] = true;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int one = 1; one < 10; one++) {
            for (int two = 1; two < 10; two++) {
                for (int three = 1; three < 10; three++) {
                    if (!(one == two || two == three || three == one)) {

                        int index = Integer.parseInt("" + one + two + three);
                        if (!check[index]) {
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
