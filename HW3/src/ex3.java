public class ex3 {
    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<Integer>(10);


        System.out.println("-------isEmpty-------");
        System.out.println(q.isEmpty());

        System.out.println("-------enque-------");
        System.out.println("enque(5), enque(2), enque(3)");
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(3);
        System.out.print("The queue: ");
        System.out.println(q);

        System.out.println("-------first-------");
        System.out.println(q.first());

        System.out.println("-------isEmpty-------");
        System.out.println(q.isEmpty());

        System.out.println("");
        System.out.println("The size of the queue: " + q.size());
        System.out.print("The length of n: ");
        q.getN();


        System.out.println("");
        System.out.println("-------deque-------");
        q.dequeue();
        System.out.print("The queue: ");
        System.out.println(q);

        System.out.println("The size of the queue: " + q.size());


        System.out.println("");
        System.out.println("--- enque(6)---");
        q.enqueue(6);
        System.out.print("The queue: ");
        System.out.println(q);
        System.out.println("The size of the queue: " + q.size());

        System.out.println("");
        System.out.println("-------deque-------");
        q.dequeue();
        System.out.print("The queue: ");
        System.out.println(q);

        System.out.println("The size of the queue: " + q.size());

        System.out.println("");
        System.out.println("-------isEmpty-------");
        System.out.println(q.isEmpty());

        System.out.println("-------first-------");
        System.out.println(q.first());

    }
}
