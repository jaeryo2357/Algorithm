package backjun.dynamic;

import java.util.Scanner;

public class q2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] floorValue = new int[n];
        int[][] saveStepValue = new int[n][2];

        for (int index = 0; index < n; index++) {
            floorValue[index] = scanner.nextInt();

            saveStepValue[index][0] = -1;  //2번 연속 건너뛴 상태 처음으로 초기화
            saveStepValue[index][1] = -1;
        }

        int oneStepValue = maxStepValue(0, 0, floorValue, saveStepValue);
        int twoStepValue = maxStepValue(1, 0, floorValue, saveStepValue);

        System.out.println(Math.max(oneStepValue, twoStepValue));
    }

    public static int maxStepValue(int floor,int step, int[] floorValue, int[][] saveStepValue) {
        if (floor == floorValue.length - 1) {
            return floorValue[floorValue.length - 1]; //마지막 계단 밟기
        } else if (floor > floorValue.length - 1) {
            return -1; //도착점을 밟지 못하는 경우로 안됨
        }
        int max = Integer.MIN_VALUE;

        if (saveStepValue[floor][step] != -1) {
            max = saveStepValue[floor][step];
        } else {
            //두 개의 계단을 오른 경우
            int value = maxStepValue(floor + 2, 0, floorValue, saveStepValue);
            if (max < value + floorValue[floor] && value != -1) {
                max = value + floorValue[floor];
            }
            //연속 3번의 개단을 한번씩 올라가지 못하니까 step 2일 경우를 제외하고 한칸 올라간 경우 계산
            if (step != 1) {
                value = floorValue[floor] + maxStepValue(floor + 1, step + 1, floorValue, saveStepValue);
            }

            if (max < value) {
                max = value;
            }

            saveStepValue[floor][step] = max;
        }

        return max;
    }
}
