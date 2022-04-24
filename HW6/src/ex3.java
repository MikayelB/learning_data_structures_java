import sources.DefaultComparator;
import sources.Entry;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ex3 {

    // right child 2f(q) + 2
    // left child 2f(q) + 1

    public static <K,V> boolean isMaxHeap(Entry<K,V>[] arr, Comparator<K> comparator){

        int lastIndex = arr.length - 1;
        Entry<K,V> last = arr[lastIndex];
        Entry<K,V> lastParent = arr[lastIndex - 1 / 2];

        if(comparator.compare(last.getKey(), lastParent.getKey()) == 1){
            if(isMaxHeap(Arrays.copyOfRange(arr, 0, lastIndex), comparator)){
                return true;
            };
        }
        return false;
    }

    public static void main(String[] args) {



        MaxPriorityQueue q = new MaxPriorityQueue();
        Entry[] arr = new Entry[q.size()];

        q.insert('1', 1);
        q.insert('2', 2);
        q.insert('3', 3);
        q.insert('4', 4);
        q.insert('5', 5);
        q.insert('6', 44);

        int i = 0;
        while(!q.isEmpty()){
            arr[i] = (q.removeMax());
        }

        Comparator comp = new DefaultComparator();
        isMaxHeap(arr, comp);
    }
}
