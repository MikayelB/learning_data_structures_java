import sources.Queue;

public class QueueArray<E> implements Queue<E> {

    public static final int CAPACITY = 1000;

    private E[] arr;
    private int n;
    private int size = 0;
    private int count = 2;

    //---constructors---
    public QueueArray(){
        this(CAPACITY);
    }
    public QueueArray(int capacity){
        arr = (E[]) new Object[capacity];
        n = arr.length;
    }
    //------------------

    //---test-------
    public void getN(){
        System.out.println(n);
    }
    //------------------

    @Override
    // O(1) since we just use the index to access the specific spot and add there
    public void enqueue(E e) {
        arr[n - count] = e;
        count++;
        size++;

    }

    @Override
    // O(n) since this one has to loop through the queue once, to change the positions for the first and the following elements
    public E dequeue() {
        if(isEmpty()){
            return null;
        }

        E answer = arr[n - 2];
        for(int i = n - 2; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        size--;
        count--;
        return answer;
     }

    @Override
    // O(1) - there isn't much to discuss here tbh
    public E first() {
        if (isEmpty()) return null;
        return arr[n - 2];
    }

    @Override
    // O(1) - there isn't much to discuss here tbh
    public int size() {
        return size;
    }

    @Override
    // O(1) - there isn't much to discuss here tbh
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else{
            return false;
        }
    }

    // function returning string representation of the queue - used for printing the queue
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = n - 1;
        for (int j=0; j < n; j++) {
            if (j > 0)
                sb.append(", ");
            sb.append(arr[k]);
            k = (k + 1) % arr.length;
        }
        sb.append(")");
        return sb.toString();
    }
}
