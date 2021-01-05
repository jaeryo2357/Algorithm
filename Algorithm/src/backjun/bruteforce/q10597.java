package backjun.bruteforce;

import java.util.LinkedList;
import java.util.Scanner;

public class q10597 {
    public static final LinkedList<Integer> saveValue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        backtrack(-1, input);
    }

    public static boolean backtrack(int position, String input) {
        if (position >= input.length() - 1) {

            boolean isAvailable = true;

            for (Integer value : saveValue) {
                if (value > saveValue.size()) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                for (Integer value : saveValue) {
                    System.out.print(value + " ");
                }
            }

            return isAvailable;
        } else {
            Integer value = 0;
            for (int i = 1; i <= 2; i++) {
                if (position + i < input.length()) {
                    value = value * 10 + Integer.parseInt(
                            input.substring(position + i, position + i + 1));

                    if (value != 0 && !saveValue.contains(value)) {
                        saveValue.add(value);
                        if (backtrack(position + i, input)) {
                            return true;
                        }
                        saveValue.remove(value);
                    }
                }
            }
            return false;
        }
    }
}
