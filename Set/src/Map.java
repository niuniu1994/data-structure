public interface Map<K,V> {
     void add(K key, V value);
     V remove(K key);
     boolean contains(K keys);
     V get(K key);
     int getSize();
     void set(K key, V value);
     boolean isEmpty();
}
