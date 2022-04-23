import sources.Entry;

public class ex3 {
    public static void main(String[] args) {
        StackSortedPriorityQueue<Integer, Integer> queue = new StackSortedPriorityQueue<>();

        System.out.println("isEmpty");
        System.out.println(queue.isEmpty());

        System.out.println("Insert");
        System.out.println(queue.insert(3, 122));
        System.out.println(queue.insert(2, 432));
        System.out.println(queue.insert(1, 654));



        System.out.println("Size: " + queue.size());
        System.out.println("Min value: " + queue.min().getValue());
        System.out.println("Remove min: " + queue.removeMin().getValue());
        System.out.println("Min value: " + queue.min().getValue());


        // the below code will empty the queue so I commented it and used only for tests
//        System.out.println("Printing the queue");
//        while(!queue.isEmpty()){
//            System.out.println(queue.removeMin().getValue());
//        }
    }
}
