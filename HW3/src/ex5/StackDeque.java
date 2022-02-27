package ex5;

import java.util.Stack;

public class StackDeque<E> implements  Deque<E> {

    int capacity = 0;

    public StackDeque() {
        Stack<E> S = new Stack<E>();
        Stack<E> T = new Stack<E>();

    }


    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        if (capacity == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }
}