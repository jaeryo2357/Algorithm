package backjun;

import java.util.*;

public class q2981 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] nums = new long[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextLong();
        }

        Arrays.sort(nums);
        long x = nums[1] - nums[0];

        for (int  i = 2; i < nums.length; i++) {
            x = gcb(x, nums[i] - nums[i - 1]);
        }

        LinkedHashSet<Long> temp = new LinkedHashSet<>();

        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                temp.add(i);
                temp.add(x / i);
            }
        }

        ArrayList<Long> list = new ArrayList<Long>(temp);
        Collections.sort(list);

        for(long num : list) {
            System.out.print(num + " ");
        }

        System.out.println(x);
    }

    //최대 공약수 구하는 함수
    public static long gcb(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return gcb(b, a % b);
    }
}
