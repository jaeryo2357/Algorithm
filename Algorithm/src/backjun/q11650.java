package backjun;

import java.io.*;
import java.util.Arrays;

public class q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        Dot[] dots = new Dot[n];

        for (int t = 0; t < n; t++) {
            String[] dot = reader.readLine().split(" ");
            int x = Integer.parseInt(dot[0]);
            int y = Integer.parseInt(dot[1]);
            dots[t] = new Dot(x, y);
        }

        Arrays.sort(dots);

        for (int t = 0; t < n; t++) {
            writer.write(dots[t].toString());
        }

        writer.close();
    }

    static class Dot implements Comparable<Dot> {
        int x;
        int y;

        Dot (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot obj) {
            int temp = this.x - obj.x;
            if (temp == 0) temp = this.y - obj.y;
            return temp;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }
    }
}
