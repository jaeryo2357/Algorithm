package backjun;

import java.util.HashMap;
import java.util.Scanner;

public class q9375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            HashMap<String, Integer> cloths = new HashMap<>();
            for (int j = 0; j < n; j++) {

                String cloth = scanner.nextLine();
                Integer count = cloths.get(cloth.split(" ")[1]);

                if (count == null) count = 1;
                else count += 1;

                cloths.put(cloth.split(" ")[1], count);
            }

            int answer = 1;

            for (String key : cloths.keySet()) {
                answer *= (cloths.get(key) + 1);
            }

            System.out.println(answer - 1);
        }
    }
}
