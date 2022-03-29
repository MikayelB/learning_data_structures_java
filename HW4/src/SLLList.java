import sources.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLLList<E> implements List<E> {

    public SinglyLinkedList sll = new SinglyLinkedList();

    @Override
    public int size() {  // O(1) returns the size() from singly linked list
        return sll.size();
    }

    @Override
    public boolean isEmpty() {  // O(1) returns the isEmpty() from singly linked list
        return sll.isEmpty();
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {   // O(n) based on the index needed to reach
        if(sll.isEmpty()) return null;
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }

        SinglyLinkedList.Node<E> curr = sll.head;

        for(int index = 0; index < i; index++){
            curr = curr.getNext();
        }
        return curr.getElement();

    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {  // O(n) based on the index needed to reach
        if(sll.isEmpty()) {
            if(i == 0){
                sll.addLast(e);
            }else{
                throw new IndexOutOfBoundsException();
            }
        };
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }

        SinglyLinkedList.Node<E> curr = sll.head;
        SinglyLinkedList.Node<E> afterCurr = curr.getNext();

        for(int index = 1; index < i; index++){
            curr = curr.getNext();
            afterCurr = curr.getNext();
        }
        SinglyLinkedList.Node<E> element = new SinglyLinkedList.Node<>(e, afterCurr.getNext());

        curr.setNext(element);
        return afterCurr.getElement();
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {  // O(n) based on the index needed to reach
        if (sll.isEmpty()) {
            if(i == 0){
                sll.addFirst(e);
                return;
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
    public E remove(int i) throws IndexOutOfBoundsException {  // O(n) based on the index needed to reach
        if(sll.isEmpty()) return null;
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }


        SinglyLinkedList.Node<E> curr = sll.head;
        SinglyLinkedList.Node<E> afterCurr = curr.getNext();

        for(int index = 0; index < i - 1; index++){
            curr = curr.getNext();
            afterCurr = curr.getNext();
        }
        curr.setNext(afterCurr.getNext());
        sll.size--;
        return afterCurr.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new SLLListIterator();
    }


    public class SLLListIterator implements Iterator<E>{
        private SinglyLinkedList.Node<E> currNode;
        private E currEl;
        private int index = 0;

        SLLListIterator(){
            currNode = sll.head;
        }
        @Override
        public boolean hasNext() {
            if(index < sll.size){
                return true;
            }
            return false;
        }

        @Override
        public E next() {

            E tmp = currNode.getElement();
            while(index <= sll.size){

                currEl = get(index);
//                System.out.println(currEl);
                index+=3;
            }

            return tmp;
//            E tmp = curr.getElement();
//            for (int i = 1; i <= 3; i++) {
//                if (curr.getNext() != null) {
//                    curr = curr.getNext();
//                }else{
//                    throw new NoSuchElementException();
//                }
//            }
//            itr++;
//            return tmp;
        }
    }
}
