package backjun.bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class q10448 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Integer> values = new ArrayList<>();

        int number = 1;
        while(true) {
            int value = number * (number + 1) / 2;
            if (value > 1000) {
                break;
            } else {
                values.add(value);
            }
            number++;
        }

        while(t > 0) {
            int n = scanner.nextInt();
            boolean isEnd = false;
            for (int i = 0; i < values.size(); i++) {
                for (int j = 0; j < values.size(); j++) {
                    for (int k = 0; k < values.size(); k++) {

                        if (values.get(i) + values.get(j) + values.get(k) == n) {
                            isEnd = true;
                        }

                        if (isEnd) {
                            break;
                        }
                    }
                    if (isEnd) {
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
            }

            if (isEnd) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            t--;
        }
    }
}
