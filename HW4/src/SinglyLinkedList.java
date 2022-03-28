public class SinglyLinkedList<E> implements Cloneable {
  //---------------- nested Node class ----------------
  public static class Node<E> {

    private E element;
    private Node<E> next;
    protected Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    public E getElement() { return element; }
    public Node<E> getNext() { return next; }

    public void setNext(Node<E> n) { next = n; }
  }

  //----------- end of nested Node class -----------


  protected Node<E> head = null;
  private Node<E> tail = null;
  protected int size = 0;

  public SinglyLinkedList() { }

  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }


  public E first() {
    if (isEmpty()) return null;
    return head.getElement();
  }

  public E last() {
    if (isEmpty()) return null;
    return tail.getElement();
  }

  public void addFirst(E e) {
    head = new Node<>(e, head);
    if (size == 0)
      tail = head;
    size++;
  }

  public void addLast(E e) {
    Node<E> newest = new Node<>(e, null);
    if (isEmpty())
      head = newest;
    else
      tail.setNext(newest);
    tail = newest;
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) return null;
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0)
      tail = null;
    return answer;
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;
    if (size != other.size) return false;
    Node walkA = head;
    Node walkB = other.head;
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false;
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  // for printing
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}
