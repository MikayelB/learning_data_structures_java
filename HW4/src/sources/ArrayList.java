package sources;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;     // default array capacity

    private E[] data;                        // generic array used for storage
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings({"unchecked"})
    public ArrayList(int capacity) {         // constructs list with given capacity
        data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }


    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length)
            resize(2 * data.length);
        for (int k = size - 1; k >= i; k--)
            data[k + 1] = data[k];
        data[i] = e;
        size++;
    }


    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)
            data[k] = data[k + 1];
        data[size - 1] = null;
        size--;
        return temp;
    }


    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    @SuppressWarnings({"unchecked"})
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp;
    }


    // function returning string representation of the ArrayList - used for printing the list

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int j = 0; j < size; j++) {
            if (j > 0) sb.append("");
            sb.append(data[j]);
        }
        sb.append("");
        return sb.toString();
    }
}

