package backjun.binaryseach;

import java.util.Scanner;

public class q16434 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int attack = scanner.nextInt();
        Room[] rooms = new Room[n];
        long minHp = 1;
        long maxHp = 0;

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            int attackOrDrink = scanner.nextInt();
            int hp = scanner.nextInt();

            if (type == 1) {
                maxHp += (long)hp * attackOrDrink;
            }

            rooms[i] = new Room(type, attackOrDrink, hp);
        }

        long answer = 0;
        while(minHp <= maxHp) {
            long middleHp = (minHp + maxHp) / 2;

            long currentAttack = attack;
            long currentHp = middleHp;
            for (int i = 0; i < n; i++) {
                Room room = rooms[i];

                if (room.type == 1) {
                    long attackCount = (room.hp / currentAttack) - 1;
                    if (room.hp % currentAttack > 0) {
                        attackCount += 1;
                    }
                    currentHp -= (Math.max(attackCount, 0)) * room.attackOrDrink;

                    if (currentHp <= 0) {
                        break;
                    }
                } else {
                    currentAttack += room.attackOrDrink;
                    currentHp = Math.min(middleHp, currentHp + room.hp);
                }
            }

            if (currentHp > 0) {
                answer = middleHp;
                maxHp = middleHp - 1;
            } else {
                minHp = middleHp + 1;
            }
        }

        System.out.println(answer);
    }

    static class Room {
        int type;
        int hp;
        int attackOrDrink;

        public Room(int type, int attackOrDrink, int hp) {
            this.type = type;
            this.hp = hp;
            this.attackOrDrink = attackOrDrink;
        }
    }
}
