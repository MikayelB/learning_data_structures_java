package sources;
import java.util.Iterator;

public interface List<E> extends Iterable<E> {

  int size();
  boolean isEmpty();
  E get(int i) throws IndexOutOfBoundsException;  // Returns the element of the list having index i; an error condition occurs if i is not in range [0, size() − 1]
  E set(int i, E e) throws IndexOutOfBoundsException;  // Replaces the element at index i with e, and returns the old element that was replaced; an error condition occurs if...
  void add(int i, E e) throws IndexOutOfBoundsException;  // Inserts a new element e into the list so that it has index i, moving all subsequent elements one index later in the list; an error condition occurs if...
  E remove(int i) throws IndexOutOfBoundsException;  // Removes and returns the element at index i, moving all subsequent elements one index earlier in the list; an error condition occurs if...
  Iterator<E> iterator();
}
