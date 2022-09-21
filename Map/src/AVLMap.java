public class AVLMap<K extends Comparable<K> , V> implements Map<K, V> {

    private AVLTree<K, V> avlTree;

    public AVLMap(AVLTree<K, V> avlTree) {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K keys) {
        return avlTree.contains(keys);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key,value);
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
