package homeWork;

import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue.push(1);
        MyQueue.push(2);
        MyQueue.peek();
        MyQueue.pop();
        MyQueue.empty();
    }

    static Stack<Integer> firstStack = new Stack<>();
    static Stack<Integer> secondStack = new Stack<>();

    public MyQueue() {

    }

    public static void push(int x) {
        firstStack.add(x);
    }


    public static int pop() {
        transferItems();
        return secondStack.pop();
    }

    private static void transferItems() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.add(firstStack.pop());
            }
        }
    }

    public static int peek() {
        transferItems();
        return secondStack.peek();
    }

    public static boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
