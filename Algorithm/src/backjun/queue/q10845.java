package backjun.queue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class q10845 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < n; i++) {
            String action = scanner.next();

            if (action.equals("front")) {
                Integer value = queue.getFront();
                Integer output = value == null ? -1 : value;
                writer.write("" + output + "\n");
            } else if (action.equals("back")) {
                Integer value = queue.getBack();
                Integer output = value == null ? -1 : value;
                writer.write("" + output + "\n");
            } else if (action.equals("size")) {
                writer.write("" + queue.getSize() + "\n");
            } else if (action.equals("empty")) {
                Integer output = queue.isEmpty() ? 1 : 0;
                writer.write("" + output + "\n");
            } else if (action.equals("pop")) {
                Integer value = queue.pop();
                Integer output = value == null ? -1 : value;
                writer.write("" + output + "\n");
            } else {
                Integer value = scanner.nextInt();
                queue.push(value);
            }
        }


        writer.close();
    }


    static class MyQueue<T> {
        MyNode<T> head;
        MyNode<T> tail;
        int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public void push(T value) {
            MyNode<T> newNode = new MyNode<T>(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                MyNode<T> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                tail = temp.next;
            }

            size++;
        }

        public T pop() {
            if (head != null) {
                MyNode<T> temp = head.next;
                T returnValue = head.value;
                head = temp;

                if (head == null) {
                    tail = null;
                }
                size--;
                return returnValue;
            } else {
                return null;
            }
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            if (head == null) return true;
            else return false;
        }

        public T getFront() {
            if (head != null) {
                return head.value;
            } else {
                return null;
            }
        }

        public T getBack() {
            if (tail != null) {
                return tail.value;
            } else {
                return null;
            }
        }
    }

    static class MyNode<T> {
        T value;
        MyNode<T> next;

        public MyNode(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
