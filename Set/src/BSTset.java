public class BSTset<E extends Comparable<E>> implements Set<E>{

    private BST<E> bsTset;

    public BSTset(){
        bsTset = new BST<>();
    }

    @Override
    public void add(E e) {
        bsTset.add(e);
    }

    @Override
    public void remove(E e) {
        bsTset.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bsTset.contain(e);
    }

    @Override
    public int getSize() {
        return bsTset.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bsTset.isEmpty();
    }

}
