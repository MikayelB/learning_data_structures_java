import sources.Entry;
import sources.HeapPriorityQueue;

public class MaxPriorityQueue<V>{
    HeapPriorityQueue<Character, V> queue = new HeapPriorityQueue<>();

    public int size(){ return  queue.size();}
    public boolean isEmpty(){ return queue.isEmpty();}

    public Entry<Character, V> insert(Character ch, V value){

        return queue.insert((char)((127 - (int)ch)), value);
    }

    public Entry<Character, V> max(){
        return queue.min();
    }

    public Entry<Character, V> removeMax(){
        return queue.removeMin();
    }
}

