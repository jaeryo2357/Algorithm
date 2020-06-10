package backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        ArrayList<CompareUser> users = new ArrayList<>();

        for (int t = 0; t < n; t++) {
            String[] user = reader.readLine().split(" ");

            users.add(new CompareUser(t, Integer.parseInt(user[0]), user[1]));
        }

        Collections.sort(users);



        for (int t = 0; t < users.size(); t++) {
            writer.write( users.get(t).toString());
        }

        writer.close();
    }

    static class CompareUser implements Comparable<CompareUser> {

        int index;
        int age;
        String name;

        CompareUser(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(CompareUser obj) {
            int temp = this.age - obj.age;
            if (temp == 0) temp = this.index - obj.index;
            return temp;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }

    }
}
