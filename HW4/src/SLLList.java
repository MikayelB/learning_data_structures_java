import sources.List;

import java.util.Iterator;

public class SLLList<E> implements List<E> {

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
    public E get(int i) throws IndexOutOfBoundsException {   // O(n) based on the index needed to reach
        if(sll.isEmpty()) return null;
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }

        SinglyLinkedList.Node<E> curr = sll.head;

        for(int index = 1; index <= i; index++){
            curr = curr.getNext();
        }
        return curr.getElement();

    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (sll.isEmpty()) {
            if(i == 0){
                sll.addFirst(e);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }

        SinglyLinkedList.Node<E> curr = sll.head;
        SinglyLinkedList.Node<E> afterCurr = curr.getNext();


        for(int index = 1; index < i; index++){
            curr = curr.getNext();
            afterCurr = curr.getNext();
        }
        SinglyLinkedList.Node<E> element = new SinglyLinkedList.Node<>(e, afterCurr);

        curr.setNext(element);
        sll.size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
