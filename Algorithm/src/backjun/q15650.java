package backjun;

import java.util.ArrayList;
import java.util.Scanner;

public class q15650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> number = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            number.add(i);
        }

        explore(m, number, "");
    }

    public static void explore(int m, ArrayList<Integer> number, String answer) {
        ArrayList<Integer> nums = new ArrayList<>(number);
        if (answer.length() >= m + m) {
            System.out.println(answer.substring(1));
            return;
        }

        for (int i = 0; i < nums.size(); ) {
            Integer num = nums.get(i);
            nums.remove(num);
            explore(m, nums, answer + " " + num);
        }
    }
}
