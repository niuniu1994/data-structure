public interface Set<E,V> {
    void add(E e, V v);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
