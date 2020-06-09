package backjun;


import java.io.*;

public class q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] before = new int[n];
        int[] after = new int[n];
        int max = -1;

        //정렬될 배열 채우기
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            before[i] = num;
            if (max < num) {
                max = num;
            }
        }

        //최대값으로 배열 설정 - 메모리 절약
        int[] nums = new int[max + 1];

        //카운팅
        for(int i = 0; i < n; i++) {
            int num = before[i];
            nums[num]++;
        }
        //누적합
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int num = before[i];
            int position = nums[num];

            after[position - 1] = num;
            nums[num]--;
        }

        for (int i = 0; i < n; i++) {
            writer.write("" + after[i] + "\n");
        }

        writer.close();
    }
}
