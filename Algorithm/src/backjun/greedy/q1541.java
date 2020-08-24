package backjun.greedy;

import java.util.Scanner;

public class q1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();

        int answer = 0;
        StringBuilder stringToNumberTemp = new StringBuilder();
        int number = 0;
        boolean isMinus = false;

        for (int index = 0; index < numbers.length(); index++) {

            char numberOrWord = numbers.charAt(index);

            if (numberOrWord >= '0' && numberOrWord <= '9') { //숫자일 경우
                stringToNumberTemp.append(numberOrWord);
            } else {
                number += Integer.parseInt(stringToNumberTemp.toString());
                stringToNumberTemp = new StringBuilder();

                if (numberOrWord == '-') {
                    if (isMinus) {
                        number *= -1;
                    } else {
                        isMinus = true;
                    }
                    answer += number;
                    number = 0;
                }
            }
        }

        number += Integer.parseInt(stringToNumberTemp.toString());
        if (isMinus) number *= -1;

        answer += number;

        System.out.println(answer);
    }
}
