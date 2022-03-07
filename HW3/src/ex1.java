public class ex1 {

    public static <E> void recReverseQueue(ArrayQueue<E> queue){

        // checking if the queue is empty
        if(queue.isEmpty()){
            return;
        }

        // saving the front item
        E frontElement = queue.first();
        // dequeue the front item while keeping it in a variable
        queue.dequeue();

        // calling the function again now with the front element taken out
        recReverseQueue(queue);

        // adding the current "frontElement" to the beginning
        queue.enqueue(frontElement);

    }


    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(10);

        // adding elements to the queue
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        // printing the queue
        System.out.println(queue.toString());
        // reversing the queue
        recReverseQueue(queue);
        // printing the new, reversed queue
        System.out.println(queue.toString());
    }

}
