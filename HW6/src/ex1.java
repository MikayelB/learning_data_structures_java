import sources.Entry;

public class ex1 {
    public static void main(String[] args) {

        /*
        In case of SortedPriorityQueue size, isEmpty, max, and removeMax will have a time complexity of O(1) since in the SortedPriorityQueue all its functions besides insert are O(1) (and since we use min for our max it will still be O(1))

        the insert will remain O(n) since the program will still have  to go through the entries in order to insert in the correct position

         */

        MaxPriorityQueue q = new MaxPriorityQueue();

        q.insert('a', 1);
        q.insert('b', 2);
        q.insert('c', 3);
        q.insert('d', 4);
        q.insert('x', 5);
        q.insert('m', 44);

        while(!q.isEmpty()){
            System.out.println(q.removeMax().getValue());
        }

    }
}
