package backjun.binaryseach;

import java.io.*;
import java.util.StringTokenizer;

public class q10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[20_000_001];

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(tokenizer.nextToken()) + 10_000_000]++;
        }

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            writer.write(arr[Integer.parseInt(tokenizer.nextToken()) + 10_000_000] + " ");
        }

        writer.close();
    }
}
