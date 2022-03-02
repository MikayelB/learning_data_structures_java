package ex4;

public interface Deque<E> {
    int size(); // returns the # of elements in the deque
    boolean isEmpty(); // returns true if the deque is empty, false otherwise
    E first(); // returns the first element (doesn't remove)
    E last(); // returns the last element (doesn't remove)
    void addFirst(E e); // inserts an element in front of the deque
    void addLast(E e); // inserts an element at the back of the deque
    E removeFirst(); // removes and returns the first element of the deque
    E removeLast(); // removes and returns the last element of the deque

}
