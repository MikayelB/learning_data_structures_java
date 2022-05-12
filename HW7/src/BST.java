import sources.AbstractBinaryTree;
import sources.ArrayList;
import sources.Position;

import java.security.PublicKey;

public class BST<E extends Comparable<E>> extends AbstractBinaryTree<E> {


    private Node<E> root;
    private int size = 0;

    public BST(){
        root.setElement(null);
    }


    // b) validate
    // O(1)
    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)) throw new IllegalArgumentException("Position type isn't a Node")
        Node<E> positionNode = (Node<E>)p;
        if(positionNode.getParent() == positionNode) throw new IllegalArgumentException("Position isn't in the tree");
        return positionNode;
    }

    // c) expand
    // O(1)
    private void expend(Node<E> node, E el){
        if(node != null) throw new IllegalArgumentException("Can't expend a non-sentinel node");

        node.setElement(el);
        node.setLeft(null);
        node.setRight(null);
        size++;
    }
    // d) shrink
    // O(1)
    private E shrink(Node<E> node){
        E tmp = node.getElement();
        node.setRight(null);
        node.setLeft(null);
        node.setElement(null);
        size--;
        return tmp;
    }

    // e) find
    public Node<E> find(E el){
        return find(root, el);
    }
    // O(n)
    private Node<E> find(Node<E> node, E el){
        if(node.getElement() == null) throw new IllegalArgumentException("The node is empty");

        int comparisonResult = el.compareTo(node.getElement());
        if(comparisonResult == 0){
            return node;
        } else if(comparisonResult > 0){
            find(node.getRight(), el);
        } else {
            find(node.getLeft(), el);
        }
        return null;
    }

    // f) insert
    // O(n)
    public Node<E> insert(Node<E> node, E el) {
        if(node.getElement() == null) {
            expend(node, el);
            return node;
        };
        int comparisonResult = el.compareTo(node.getElement());
        if(comparisonResult == 0){
            throw new IllegalArgumentException("value already exists in the BST")
        } else if(comparisonResult > 0){
            node.setRight(insert(node.getRight(), el));
        } else {
            node.setLeft(insert(node.getLeft(), el));
        }
        return node;
    }

    // g) remove
    // O(1)
    public Node<E> remove(E el){
        Node<E> nodeToRemove = find(el);
        shrink(nodeToRemove);
        return nodeToRemove;
    }

    // h) traversals
    // inorder
    public Iterable<Position<E>> inorderCall(){
        ArrayList<Position<E>> arr = new ArrayList<Position<E>>();
        inorder(root, arr);
        return arr;
    }

    private void inorder(Node<E> node, ArrayList<Position<E>> arrList){
        // didn't come up with this yet
    }



    // O(1)
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return validate(p).getLeft();
    }

    // O(1)
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return validate(p).getRight();
    }

    // O(1)
    @Override
    public Position<E> root() {
        return root;
    }

    // O(1)
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).getParent();
    }

    // inner Node class
    private static class Node<E> implements Position<E> {
        private E el;
        private Node<E> parent;
        private Node<E> rightChild;
        private Node<E> leftChild;

        public Node(E el, Node<E> parent, Node<E> rightChild, Node<E> leftChild){
            this.el = el;
            this.parent = parent;
            this.rightChild = rightChild;
            this.leftChild = leftChild;
        }

        // accessors
        public  E getElement() {return el;}
        public Node<E> getParent() {return parent;}
        public Node<E> getRight() {return rightChild;}
        public Node<E> getLeft() {return leftChild;}

        // setters
        public void setElement(E e) {el = e;}
        public void setParent(Node<E> par) {parent = par;}
        public void setRight(Node<E> rightCh) {rightChild = rightCh;}
        public void setLeft(Node<E> leftCh) {leftChild = leftCh;}

    }

}
