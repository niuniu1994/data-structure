public class LinkedListMap<K ,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this.key = key;
            value = null;
            next = null;
        }

        public Node(){
            this(null,null,null);
        }

        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }


    private Node dummyhead;
    private int size;

    public LinkedListMap(){
        dummyhead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node cur = getNode(key);
        if(cur == null) {
            dummyhead.next = new Node(key, value, dummyhead.next);
            size++;
        } else
            cur.value = value;
    }

    @Override
    public V remove(K key) {
        Node cur = dummyhead;
        while (cur.next != null){
            if(key.equals(cur.next.key)){
                Node goal = cur.next;
                cur.next = goal.next;
                goal.next = null;
                size--;
                return goal.value;
            }else
                cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K keys) {
        return getNode(keys) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null:node.value;
    }

    public Node getNode(K key) {
        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(K key, V value) {
        Node cur = getNode(key);
        if(cur != null)
            cur.value = value;
        else
            throw new IllegalArgumentException(key + " doesnt exist");

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
