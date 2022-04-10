import sources.AbstractTree;
import sources.ArrayList;
import sources.Position;

import java.util.List;

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
        // a)
        public Node<E> getChild(int i){ return children.get(i); }
        // b)
        public E removeChild(int i) {return children.remove(i).getElement();}
        // c)
        public Node<E> setChild(int i, Node<E> e){ return children.set(i, e);}
        // d)
        public void addChild(int i, Node<E> e){ children.add(i, e);}

        // default update methods
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
    } //----------- end of nested Node class -----------



    // 2)
    // a)
    /** Factory function to create a new node storing element e. */
    protected Node<E> createNode(E e, Node<E> parent,
                                                  ArrayList<Node<E>> children) {
        return new Node<E>(e, parent, children);
    }

    // b)
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;       // safe cast
        if (node.getParent() == node)     // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // LinkedGeneralTree instance variables
    protected Node<E> root = null;     // root of the tree
    private int size = 0;              // number of nodes in the tree

    // constructor
    public LinkedGeneralTree() { }      // constructs an empty general tree


    //------------ override required ones------------
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> el = validate(p);
        return el.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {

        Node<E> node = validate(p);
        int size = node.children.size();

        List<Position<E>> snapshot = (List<Position<E>>) new ArrayList<Position<E>>();
        for(int i = 0; i < size; i++){
            snapshot.add(i, node.children.get(i));
        }
        return snapshot;
    }

    //------------ override required ones end------------

    // c)
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null);
        size = 1;
        return root;
    }

    // d)
    public Position<E> ithChild(Position<E> p, int i){
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");

        Node<E> node = validate(p);
        return node.getChild(i);
    }

    // e)
    public Position<E> addIth(Position<E> p, E e, int i){
        Node<E> node = validate(p);
        Node<E> child = createNode(e, node, null);

        node.addChild(i, child);
        return node.getChild(i);
    }

    // f)
    public Position<E> addFirst(Position<E> p, E e){
        Node<E> node = validate(p);
        Node<E> newFirstChild = createNode(e, node, null);

        node.addChild(0, newFirstChild);
        return node.getChild(0);
    }


}
