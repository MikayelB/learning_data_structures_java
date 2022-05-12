package sources;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

  /** The primary storage for elements of the queue */
  private CircularlyLinkedList<E> circle = new CircularlyLinkedList<>();

  /** Creates an empty queue. */
  public LinkedCircularQueue() { }

  @Override
  public int size() {
    return circle.size();
  }

  @Override
  public boolean isEmpty() {
    return circle.isEmpty();
  }

  @Override
  public void enqueue(E element) {
    circle.addLast(element);
  }

  @Override
  public E first() {
    return circle.first();
  }

  @Override
  public E dequeue() {
    return circle.removeFirst();
  }

  @Override
  public void rotate() {
    circle.rotate();
  }

  public String toString() {
    return circle.toString();
  }

}
