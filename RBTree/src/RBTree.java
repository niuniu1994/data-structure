import java.awt.*;

public class RBTree<K extends Comparable<K>, V>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V val;
        public Node left, right;
        public boolean color;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    //每一个叶子节点（空节点）是黑色的
    public boolean isRed(Node node){
        if (node == null){
            return BLACK;
        }
        return node.color;
    }

    public RBTree() {
        size = 0;
        root = null;
    }

    public void add(K key, V value) {
        root = add(key, value, root);
        root.color = BLACK;//根结点必然是红色
    }

    //左旋转,主要目的是保持红节点的左倾
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipcolors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node add(K key, V val, Node node) {
        if (node == null) {
            size++;
            return new Node(key, val);//默认插入红色节点
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(key, val, node.left);
        else if (key.compareTo(node.key) > 0)
            node.right = add(key, val, node.right);
        else if (key.equals(node.key))
            node.val = val;

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if (isRed(node.left) && isRed(node.right))
            flipcolors(node);

        return node;
    }

    public Node getNode(K key) {
        return getNode(root, key);
    }

    //返回key对应值的Node
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (node.key.equals(key))
            return node;

        if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return getNode(node.right, key);
        return node;
    }

    //删除键为key的节点

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                Node cur = node.right;
                node = null;//为了优化程序，不写这一步java的垃圾回收机制也会回收的
                size--;
                return cur;
            }
            if (node.right == null) {
                Node cur = node.left;
                node = null;
                size--;
                return cur;
            }

            Node suc = minimum(node.right);
            suc.right = removeMin(node.right);
            suc.left = node.left;
            node.left = node.right = null;
            return suc;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中最小的节点
    //返回删除节点后新的二分搜索树的根 因为有时候根就是最小节点 删除后根就根就会改变
    //所以有删除元素的的操作都要考虑根的变化。
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rNode = node.right;
            node.right = null;
            size--;
            return rNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null ? true : false;
    }

    //返回value值
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    public int getSize() {
        return size;
    }

    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("node is null");
        node.val = val;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
