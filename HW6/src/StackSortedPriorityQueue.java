import sources.AbstractPriorityQueue;
import sources.Entry;

import java.util.Stack;

public class StackSortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    Stack<Entry<K,V>> st = new Stack<>();

    // O(1) uses the size stacks size
    public int size(){
        return st.size();
    }

    // O(1) same as above
    public boolean isEmpty(){
        return st.isEmpty();
    }

    // O(n) since the new entry might have to go below all other entries so it will go through all of them
    public Entry<K, V> insert(K key, V value){
        PQEntry<K, V> entry = new PQEntry<>(key, value);

        insertHelper(entry);
        int sz = size();
        return entry;
    }

    // this is a helper function for the one above
    private void insertHelper(PQEntry<K, V> en){
        if(st.isEmpty() || compare(en, st.peek()) == -1){
            st.push(en);
            return;
        }

        Entry<K,V> tmp = st.pop();
        insertHelper(en);
        st.push(tmp);

    }

    @Override
    // O(1) since uses stack's peek which is O(1)
    public Entry<K, V> min() {
        return st.peek();
    }

    @Override
    // O(1) since uses stack's pop which is O(1)
    public Entry<K, V> removeMin() {
        return st.pop();
    }
}
