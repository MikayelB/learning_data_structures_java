package ex5;

public class DoublyLinkedList<E> {
    // Node class----------------------------------------
    private static class Node<E> {
        private E el;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next) {
            el = element;
            prev = previous;
            this.next = next;
        }

        // accessor methods
        public E getElement() {
            return el;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }
    }
    //---------------------------------------------------

    protected Node<E> header;
    protected Node<E> trailer;
    private int size = 0;


    // New empty list constructor
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);

        header.setNext(trailer);
    }

    //---------- accessor methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement(); // header doesn't have an element that's why we do .getNext()
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement(); // using .getPrev() since trailer doesn't have an element
    }

    //---------- public update methods
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    //---------- private update methods
    private void addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newest = new Node<>(e, prev, next);

        prev.setNext(newest);
        next.setPrev(newest);

        size++;
    }

    private E remove(Node<E> node) {
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);

        size--;
        return node.getElement();
    }

    // exercise methods

}












