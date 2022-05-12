package sources;

public interface Position<E> {

  E getElement() throws IllegalStateException;
}
