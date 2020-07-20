package backjun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


//기수정렬
public class q1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rooms.add(new Room(scanner.nextInt(), scanner.nextInt()));
        }

        rooms.sort(Comparator.comparingInt(o -> o.startTime));

        rooms.sort(Comparator.comparingInt(o -> o.endTime));

        int answer = 0;
        int endTime = 0;

        for (Room room : rooms) {
            if (endTime <= room.startTime) {
                endTime = room.endTime;
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static class Room{
        int startTime;
        int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
