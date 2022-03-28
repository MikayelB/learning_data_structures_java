import org.w3c.dom.Node;
import sources.List;
import sources.SinglyLinkedList;

import java.util.Iterator;

public class SLLList<E> implements List {

    public SinglyLinkedList sll = new SinglyLinkedList();

    @Override
    public int size() {
        return sll.size();
    }

    @Override
    public boolean isEmpty() {
        return sll.isEmpty();
    }

    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        SinglyLinkedList.Node<E> curr = sll.head;

        for(int index = 0; index < i; index++){
            curr = curr.getNext();
        }
        return curr.getElement();

    }

    @Override
    public Object set(int i, Object o) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, Object o) throws IndexOutOfBoundsException {

    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
