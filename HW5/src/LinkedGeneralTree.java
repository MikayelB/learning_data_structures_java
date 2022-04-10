import sources.*;

import java.util.List;
import java.util.Stack;

public class LinkedGeneralTree<E> extends AbstractTree<E> {


    //---------------- nested Node class ----------------
    /** Nested static class for a general tree node. */
    protected static class Node<E> implements Position<E> {
        private E element;          // an element stored at this node
        private Node<E> parent;     // a reference to the parent node (if any)
        private ArrayList<Node<E>> children;            // a reference to the children arrayList


        // constructor
        public Node(E e, Node<E> above, ArrayList<Node<E>> children) {
            element = e;
            parent = above;
            children = new ArrayList<Node<E>>();
        }


        // accessor methods
        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public ArrayList<Node<E>> getChildren() { return children; }

        // homework methods
        // 1)
        // a)  O(1) since it uses index to get the child
        public Node<E> getChild(int i){ return children.get(i); }
        // b)  O(n) since based on which child to remove the ones on the right have to move left to fill in the space
        public E removeChild(int i) {return children.remove(i).getElement();}
        // c)  O(1) since it just replaces the element with index
        public Node<E> setChild(int i, Node<E> e){ return children.set(i, e);}
        // d)  O(n) since based on the index, the ones after it have to move to right
        public void addChild(int i, Node<E> e){ children.add(i, e);}

        // default update methods
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
    } //----------- end of nested Node class -----------



    // 2)
    // a)  O(1) just creates a node
    protected Node<E> createNode(E e, Node<E> parent,
                                                  ArrayList<Node<E>> children) {
        return new Node<E>(e, parent, children);
    }

    // b)  O(1) just gives us the node in the position p
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // LinkedGeneralTree instance variables
    protected Node<E> root = null;
    private int size = 0;

    // constructor
    public LinkedGeneralTree() { }      // constructs an empty general tree


    //------------ override required ones------------
    @Override  // O(1)
    public Position<E> root() {
        return root;
    }

    @Override  // O(1)
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> el = validate(p);
        return el.getParent();
    }

    @Override  // O(n) since based on size
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {

        Node<E> node = validate(p);
        int size = node.children.size();

        List<Position<E>> snapshot = new java.util.ArrayList<>();
        for(int i = 0; i < size; i++){
            snapshot.add(i, node.children.get(i));
        }
        return snapshot;
    }

    //------------ override required ones end------------

    // c)  O(1) just creates a new node root
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null);
        size = 1;
        return root;
    }

    // d)  O(1) uses index to get the child
    public Position<E> ithChild(Position<E> p, int i){
        if (isEmpty()) throw new IllegalStateException("Tree is empty");

        Node<E> node = validate(p);
        return node.getChild(i);
    }

    // e)  O(n) since uses ArrayList's add, meaning the elements in indexes to the right have to move right
    public Position<E> addIth(Position<E> p, E e, int i){
        Node<E> node = validate(p);
        Node<E> child = createNode(e, node, null);

        node.addChild(i, child);
        size++;
        return node.getChild(i);
    }

    // f)  O(n) since all elements have to move right so that the first one fits before the rest
    public Position<E> addFirst(Position<E> p, E e){
        Node<E> node = validate(p);
        Node<E> newFirstChild = createNode(e, node, null);

        node.addChild(0, newFirstChild);
        size++;
        return node.getChild(0);
    }

    // g)  O(1) since uses ArrayList's add but there isn't an element whch has to move to the right
    public Position<E> addLast(Position<E> p, E e){
        Node<E> node = validate(p);
        Node<E> newLastChild = createNode(e, node, null);

        node.addChild(size, newLastChild);
        size++;
        return node.getChild(size - 1);
    }

    // h)  O(1) since it just sets an element at a position
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;

    }

    // i)  O(n) since loops throught the Parent node's children to find the needed child to replace
    public void remove(Position<E> p){
        Node<E> nodeToRemove = validate(p);

        if(nodeToRemove.children.isEmpty()){
            return;
        }
        if(nodeToRemove.children.size() > 1){
            throw new IllegalArgumentException("The node has more than 1 child");
        }

        Node<E> parentNode = nodeToRemove.parent;

        int i;
        for(i = 0; i < parentNode.children.size(); i++){
            if(parentNode.getChild(i) == nodeToRemove){
                break;
            }
        }
        parentNode.setChild(i, nodeToRemove.getChild(0));
        size--;
    }

    // j)

    // preorder  O(n) traverses through the tree
    private void preorderSubtree(Position<E> p, java.util.ArrayList<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    public Iterable<Position<E>> preorder(){
        java.util.ArrayList<Position<E>> snapshot = new java.util.ArrayList<>();

        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }


    // postorder  O(n) traverses through the tree
    private void postorderSubtree(Position<E> p, java.util.ArrayList<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }

    public Iterable<Position<E>> postorder( ) {
        java.util.ArrayList<Position<E>> snapshot = new java.util.ArrayList<>();

        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    // breadthfirst    O(n^2) traverses through the tree but there is a 'for' inside a 'while'
    public Iterable<Position<E>> breadthfirst() {

        java.util.ArrayList<Position<E>> snapshot = new java.util.ArrayList<>();

        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());

            while (!queue.isEmpty()) {
                Position<E> p = queue.dequeue();
                snapshot.add(p);

                for (Position<E> c : children(p))
                    queue.enqueue(c);
            }
        }
        return snapshot;
    }


    // k)  O(n^2) since calls breadthfirst
    public Iterable<Position<E>> positions(){ return breadthfirst();}


    // l) O(n) since will iterate over the tree without multiple loops in each other

    // the below code is not working so I commented it out

//    public Iterator<E> Iterator(){
//        return new TreeIterator();
//    }
//
//    public class TreeIterator(){
//        Stack<Node<E>> someStack = new Stack<Node<E>>();
//
////       private Node<E> next;
//
//        // constructor
//        public TreeIterator() {
//            someStack.push(root);
//
//        }
//    }

}



















