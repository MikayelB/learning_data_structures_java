package ex5;

import java.util.Stack;

public class Run {
    public static void main(String[] args) {
//        Stack<Integer> S = new Stack<Integer>();
//        S.push(3);
//        S.push(5);
//        System.out.println(S);

        StackDeque<Integer> stack = new StackDeque<Integer>();

        stack.addFirst(5);
        System.out.println(stack);
        stack.addFirst(2);
        stack.addFirst(9);
        stack.printStackDeque();
    }
}
