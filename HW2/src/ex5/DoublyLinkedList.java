package ex5;

public class DoublyLinkedList<E> {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        list.addLast(4);
        list.addLast(5);
        list.addLast(123);
        list.addLast(52);

        // a)
        list.printDLL(list.header);

        // b)  uncomment below to make it work (commented to make c work since it would have been sorted)
//        list.selectionSort(list.header);
//        System.out.println("Selection sorted result");
//        list.printDLL(list.header);

        // c)
        list.insertionSort(list.header);
        System.out.println("Insertion sorted result");
        list.printDLL(list.header);

    }


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
    // a)
    public void printDLL(Node<E> header){

        if(isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        Node<E> temp = header;      // make a temp in order to not edit our header

        while(temp.getNext() != trailer){
            System.out.println(temp.next.getElement());
            temp = temp.next;
        }
    }

    // b)
    public void selectionSort(Node<Integer> header) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }

        Node<Integer> outerCurrent = header.next;
        Node<Integer> innerCurrent = header;      // make a innerCurrent in order to not edit our header
        Node<Integer> min = header.next;

        while (outerCurrent != trailer) {
//            System.out.println("start iteration with min " + min.getElement());
            while (innerCurrent.next != trailer) {
                innerCurrent = innerCurrent.next;

                if (min.getElement() > innerCurrent.getElement()) {
                    min = innerCurrent;
//                    System.out.println("change min " + min.getElement());
                }
            }

            if (min == outerCurrent) {
                outerCurrent = outerCurrent.next;
                innerCurrent = outerCurrent;
                min = innerCurrent;
                continue;
            }

            min.prev.setNext(min.next);
            min.next.setPrev(min.prev);
            min.setPrev(outerCurrent.prev);
            outerCurrent.prev.setNext(min);
            min.setNext(outerCurrent);
            outerCurrent.setPrev(min);
            innerCurrent = outerCurrent;
            min = innerCurrent;
        }
    }

    // c)
    public void insertionSort(Node<Integer> header){
        if(isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        Node<Integer> current = header.next;

        // make a innerCurrent in order to not edit our header
        while(current != trailer){
            if(current.next.getElement() < current.getElement()){
                Node<Integer> tempCur = current;
                Node<Integer> temp = current.next;
                while(temp.getElement() < tempCur.getElement()){
                    tempCur = tempCur.prev;
                }

                tempCur = tempCur.next;
                temp.prev.setNext(temp.next);
                temp.next.setPrev(temp.prev);
                temp.setPrev(tempCur.prev);
                tempCur.prev.setNext(temp);
                temp.setNext(tempCur);
                tempCur.setPrev(temp);
            }
            current = current.next;
        }
    }
}












