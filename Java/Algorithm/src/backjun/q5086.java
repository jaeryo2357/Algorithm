package backjun;

import java.util.Scanner;

public class q5086 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        while (firstNumber != 0 && secondNumber != 0) {

            if (secondNumber / firstNumber > 0 && secondNumber % firstNumber == 0) {
                System.out.println("factor");
            } else if (firstNumber / secondNumber > 0 && firstNumber % secondNumber == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }

            firstNumber = scanner.nextInt();
            secondNumber = scanner.nextInt();
        }
    }
}
