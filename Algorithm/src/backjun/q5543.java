package backjun;

import java.util.Scanner;

public class q5543 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        int myBurger = 2001;
        int myDrink = 2001;

        for (int t = 0; t < 3; t++) {
            int burger = scanner.nextInt();
            if (myBurger > burger) {
                myBurger = burger;
            }
        }

        for (int t = 0; t < 2; t++) {
            int drink = scanner.nextInt();
            if (myDrink > drink) {
                myDrink = drink;
            }
        }

        System.out.println(myBurger + myDrink - 50);
    }
}
