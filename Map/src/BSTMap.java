public class BSTMap<K extends Comparable<K> , V> implements Map<K, V> {

    private class Node{
        public K key;
        public V val;
        public  Node left,right;

        public Node(K key, V val){
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        size = 0;
        root = null;
    }


    @Override
    public void add(K key, V value) {
            root = add(key,value,root);
    }

    private Node add(K key, V val,Node node){
        if (node == null){
            size++;
            return new Node(key,val);
        }
        if(key.compareTo(node.key) < 0)
            node.left = add(key, val,node.left);
        else if(key.compareTo(node.key) > 0)
            node.right = add(key, val,node.right);
        else if(key.equals(node.key))
            node.val = val;
        return node;
    }

    public Node getNode(K key){
        return getNode(root,key);
    }

    //返回key对应值的Node
    private Node getNode(Node node,K key){
        if(node == null)
            return null;

        if(node.key.equals(key))
            return node;

        if(key.compareTo(node.key) < 0)
            return getNode(node.left,key);
        else if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
        return node;
    }

    //删除键为key的节点

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }
        else {
            if (node.left == null && node.right == null) {
                size--;
                return null;
            } else if (node.left == null) {
                Node cur = node.right;
                node = null;//为了优化程序，不写这一步java的垃圾回收机制也会回收的
                size--;
                return cur;
            } else if (node.right == null) {
                Node cur = node.left;
                node = null;
                size--;
                return cur;
            } else{
                Node suc = minimum(node.right);
                suc.right = removeMin(node.right);
                suc.left = node.left;
                node.left = node.right =null;
                return suc;
            }
        }
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中最小的节点
    //返回删除节点后新的二分搜索树的根 因为有时候根就是最小节点 删除后根就根就会改变
    //所以有删除元素的的操作都要考虑根的变化。
    private Node removeMin(Node node){
        if(node.left == null){
            Node rNode = node.right;
            node.right = null;
            size--;
            return rNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null ? true:false;
    }

    //返回value值
    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null:node.val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(K key, V val) {
       Node node  = getNode(root,key);
       if (node == null)
           throw new IllegalArgumentException("node is null");
       node.val = val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
