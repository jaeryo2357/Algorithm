package backjun;

import java.util.Scanner;
import java.util.ArrayList;

public class q2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //n장의 카드
        int m = scanner.nextInt(); //3장의 카드의 합 <= m

        ArrayList<Integer> cards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cards.add(scanner.nextInt());
        }

        System.out.println(blackJack(cards,0, 0, m));
    }

    public static int blackJack(ArrayList<Integer> cards, int count, int current, int max) {

        if (count == 3) {
            return current;
        }

        ArrayList<Integer> lastCards = new ArrayList<>();
        lastCards.addAll(cards);

        int currentMax = -1;

        for (int index = 0; index < lastCards.size(); index++) {
            Integer card = lastCards.get(index);
            lastCards.remove(index);

            int result = blackJack(lastCards,count + 1, card + current, max);
            if (currentMax < result && result <= max) {
                currentMax = result;
            }
            lastCards.add(index, card);
        }
        return currentMax;
    }
}
