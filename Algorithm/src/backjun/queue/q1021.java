package backjun.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class q1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();//뽑으려고 하는 수

        CircleQueue queue = new CircleQueue(n);

        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            Integer position = scanner.nextInt();

            answer += queue.dequeue(position);

        }

        System.out.println(answer);
    }

    static class CircleQueue  {

        ArrayList<Integer> queue = new ArrayList<>();
        int maxSize = 1;

        CircleQueue(int size) {
            maxSize = size;
        }


        public synchronized void enqueue(Integer integer) {
            queue.add(integer);
        }


        public Integer dequeue() {
            return queue.remove(0);
        }


        public synchronized Integer dequeue(Integer positionValue){

            int value = queue.get(0);
            if (positionValue == value) {

                dequeue();
                return 0;
            }

            int distance;

            int frontDistance = 0;
            int backDistance = 0;
            int targetPosition = queue.indexOf(positionValue);

            frontDistance = targetPosition;
            backDistance = Math.abs(queue.size() - targetPosition);

            distance = Math.min(frontDistance, backDistance);

            if (frontDistance > backDistance) {
                backCircle(backDistance);
            } else {
                frontCircle(frontDistance);
            }

            dequeue();

            return distance;
        }

        private void frontCircle(int time) {
            for (int i = 0; i < time; i++) {
                Integer value = queue.get(0);
                queue.remove(0);
                queue.add(value);
            }
        }

        private void backCircle(int time) {
            for (int i = 0; i < time; i++) {
                Integer value = queue.get(queue.size() - 1);
                queue.remove(queue.size() - 1);
                queue.add(0, value);
            }
        }


        public synchronized boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
