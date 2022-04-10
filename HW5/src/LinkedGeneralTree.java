import sources.AbstractTree;
import sources.ArrayList;
import sources.Position;

public class LinkedGeneralTree<E> extends AbstractTree<E> {


    //---------------- nested Node class ----------------
    /** Nested static class for a binary tree node. */
    protected static class Node<E> implements Position<E> {
        private E element;          // an element stored at this node
        private LinkedBinaryTree.Node<E> parent;     // a reference to the parent node (if any)
        private ArrayList<Node<E>> children;            // a reference to the children arrayList

        public Node(E e, LinkedBinaryTree.Node<E> above, ArrayList<Node<E>> children) {
            element = e;
            parent = above;
            children = new ArrayList<Node<E>>();
        }

        // accessor methods
        public E getElement() { return element; }
        public LinkedBinaryTree.Node<E> getParent() { return parent; }
        public ArrayList<Node<E>> getChildren() { return children; }

        // update methods
        public void setElement(E e) { element = e; }
        public void setParent(LinkedBinaryTree.Node<E> parentNode) { parent = parentNode; }
    } //----------- end of nested Node class -----------





    @Override
    public Position root() {
        return null;
    }

    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Position> children(Position p) throws IllegalArgumentException {
        return null;
    }
}
