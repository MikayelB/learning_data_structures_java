import sources.Deque;

import java.util.Stack;

public class StackDeque<E> implements Deque<E> {

    int capacity = 0;
    int topS = -1;
    int topT = -1;

    Stack<E> S;
    Stack<E> T;

    public StackDeque() {
        S = new Stack<>();
        T = new Stack<>();
    }


    @Override
    // O(1)
    public int size() {
        return S.size();
    }

    @Override
    // O(1)
    public boolean isEmpty() {
        if (capacity == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    // O(1)
    public E last() {
        return S.peek();
    }

    @Override
    // O(n) since we loop through the stack
    public E first() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        for(int i = 1; i < capacity; i++){
            T.push(S.pop());
        }
        E first  = S.peek();
        for(int i = 1; i < capacity; i++){
            S.push(T.pop());
        }
        return first;
    }

    @Override
    // O(n) since we loop through the stack
    public void addFirst(E e) {
        if(topS != -1){
            for(int i = 1; i <= capacity; i++){
                T.push(S.pop());
            }
            S.push(e);
            for(int i = 1; i <= capacity; i++){
                S.push(T.pop());
            }
            topS++;
            capacity++;
        } else {
            S.push(e);
            topS++;
            capacity++;
        }
    }

    @Override
    // O(1)
    public void addLast(E e) {
        S.push(e);
        capacity++;
    }

    @Override
    // O(n) since we loop through the stack
    public E removeFirst() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }

        if(topS == 0){
            capacity--;
            return S.pop();

        } else{
            for(int i = 1; i < capacity; i++){
                T.push(S.pop());
            }
            E temp = S.pop();
            for(int i = 1; i < capacity; i++){
                S.push(T.pop());
            }
            capacity--;
            return temp;
        }
    }

    @Override
    // O(1)
    public E removeLast() {
        capacity--;
        return S.pop();

    }

    //---Helper functions
    public void printStackDeque(){
        Stack<E>temp = new Stack<>();
        for(int i = 1; i <= capacity; i++){
            System.out.println(temp.push((E) S.pop()));
        }
        for(int i = 1; i <= capacity; i++){
            S.push(temp.pop());
        }
    }
}