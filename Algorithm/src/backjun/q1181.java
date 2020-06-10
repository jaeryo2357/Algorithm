package backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        ArrayList<CompareString> strings = new ArrayList<>();

        for (int t = 0; t < n; t++) {
            CompareString s = new CompareString(reader.readLine());
            if (!strings.contains(s)) {
                strings.add(s);
            }
        }

        Collections.sort(strings);



        for (int t = 0; t < strings.size(); t++) {
            writer.write( strings.get(t).value+ "\n");
        }

        writer.close();
    }

    static class CompareString implements Comparable<CompareString> {

        String value;

        CompareString(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(CompareString obj) {
            int temp = this.value.length() - obj.value.length();
            if (temp == 0) temp = value.compareTo(obj.value);
            return temp;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CompareString) {
                return this.value.equals(((CompareString)obj).value);
            }
            return false;
        }
    }
}
