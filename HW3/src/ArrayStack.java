import sources.Stack;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY=1000;
    private E[] arr;
    private int top = -1;
    private int size = 0;

    //----constructors----
    public ArrayStack() { this(CAPACITY); }

    public ArrayStack(int capacity) {
        arr = (E[]) new Object[capacity];
    }
    //--------------------

    public void resize(){
        if(size <(arr.length / 4)){
            E[] temp = (E[]) new Object[arr.length / 2];

            for(int i = 0; i < temp.length; i++){
                temp[i] = arr[i];
            }

            arr = temp;

        } else if (size == arr.length){
            E[] temp = (E[]) new Object[arr.length * 2];

            for(int i = 0; i < arr.length; i++){
                temp[i] = arr[i];
            }

            arr = temp;
        } else {
            return;
        }
    }

    @Override
    public int size() {
//        System.out.println("arr.length = " + arr.length);  //test
        return (size);
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public void push(E e) {
        resize();
        arr[++top] = e;
        size++;

    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return arr[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = arr[top];
        arr[top] = null;
        top--;
        size--;
        resize();
        return answer;
    }

    //---Helper functions
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = top; j >= 0; j--) {
            sb.append(arr[j]);
            if (j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
