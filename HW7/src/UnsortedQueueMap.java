import sources.*;

import java.security.Key;

public class UnsortedQueueMap<K extends Comparable<K>,V extends Comparable<V>> extends AbstractMap<K,V> {

   private LinkedCircularQueue<MapEntry<K,V>> q = new LinkedCircularQueue<MapEntry<K, V>>();


   public UnsortedQueueMap(){};

   // O(1) calls, another size()
    @Override
    public int size() {
        return q.size();
    }


    // O(n), looping through the queue
    @Override
    public V get(K key) {
        int i = 0;
        while(i != q.size()){
            if(q.first() != key) q.rotate();
            else return q.first().getValue();
            i++;
        }
        return null;
    }

    // O(n), looping through the queue
    @Override
    public V put(K key, V value) {
        int i = 0;
        while(i != q.size()){
            if(key.compareTo(q.first().getKey()) == 0){
              return q.first().setValue(value);
            }
            q.rotate();
            i++;
        }
        q.enqueue(new MapEntry<K, V>(key, value));
        return null;
    }

    // O(n), looping through the queue
    @Override
    public V remove(K key) {
        int i = 0;
        while(i != q.size()){
            if(key.compareTo(q.first().getKey()) == 0){
                V tmp = q.first().getValue();
                q.dequeue();
                return tmp;
            }
            q.rotate();
            i++;
        }
        return null;
    }

    // O(n), looping through the queue
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> list = new ArrayList<Entry<K, V>>();

        int i = 0;
        while(i != q.size()){
            list.add(i, q.first());
            q.rotate();
            i++;
        }
        return list;
    }


}