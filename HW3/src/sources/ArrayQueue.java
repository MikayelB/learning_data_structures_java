package sources;

import sources.Queue;
/*----------------------------------------------------------------------
    This is the tradition ArrayQueue implementation  used in ex1, for ex3 check QueueArray class in src
---------------------------------------------------------------------
*/

public class ArrayQueue<E> implements Queue<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayQueue() {this(CAPACITY);}

    @SuppressWarnings({"unchecked"})

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return (size == 0); }

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }


    // function returning string representation of the queue - used for printing the queue
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = front;
        for (int j=0; j < size; j++) {
            if (j > 0)
                sb.append(", ");
            sb.append(data[k]);
            k = (k + 1) % data.length;
        }
        sb.append(")");
        return sb.toString();
    }

}
