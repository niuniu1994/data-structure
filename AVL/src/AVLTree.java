import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V val;
        public Node left, right;
        private int height;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        size = 0;
        root = null;
    }

    //得到节点高度值
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    //得到平衡因子
    private int getBlanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //利用中inorder遍历特性判断是否是bst
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);

        for (int i = 1; i < keys.size(); i++){
            if (keys.get(i - 1).compareTo( keys.get(i)) > 0)
                return false;
        }
        return true;
    }

    public boolean isBlanced(){
        return isBlanced(root);
    }

    //判断树是否平衡
    private boolean isBlanced(Node node){

        if (node == null)
            return true;

        if (Math.abs(getBlanceFactor(node)) > 1)
            return false;

       return isBlanced(node.left) && isBlanced(node.right);
    }

    private void inOrder(Node node, ArrayList<K> keys){

        if (node == null)
            return;

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }


    @Override
    public void add(K key, V value) {
        root = add(key, value, root);
    }

    private Node add(K key, V val, Node node) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(key, val, node.left);
        else if (key.compareTo(node.key) > 0)
            node.right = add(key, val, node.right);
        else if (key.equals(node.key))
            node.val = val;

        //更新节点高度值
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        //平衡维护
        //getBlanceFactor(node.left) >= 0 就是说左子树的高度大于或等于右子树的高度
        //getBlanceFactor(node.left) = 0 的情况在add时并不会出现然而在remove时则会出现。
        if (getBlanceFactor(node) > 1 && getBlanceFactor(node.left) >= 0){
            //LL情况
            return rightRotate(node);
        }else if (getBlanceFactor(node) < -1 && getBlanceFactor(node.right) <= 0){
            //RR情况
            return leftRotate(node);
        }else if (getBlanceFactor(node) > 1 && getBlanceFactor(node.left) < 0){
            //LR情况
            node.left = leftRotate(node.left);
            //即使经过左旋后以node.left为根的树并不满足AVL树的条件再经过对node的右旋后还是会的到以node为根的AVL树
            return rightRotate(node);
        }else if (getBlanceFactor(node) < -1 && getBlanceFactor(node.right) > 0){
            //RL情况
            node.right = rightRotate(node.right);
            //即使经过右旋后以node.right为根的树并不满足AVL树的条件再经过对node的左旋后还是会的到以node为根的AVL树
            return leftRotate(node);
        }

        return node;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        //向右旋转
        x.right = y;
        y.left = T3;

        //更新高度值
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.right),getHeight(x.left)) + 1;

        return x;
    }
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        //向左旋转
        x.left = y;
        y.right = T2;

        //更新高度值
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.right),getHeight(x.left)) + 1;
        return x;
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
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        Node retNode;

        if (node == null)
            return null;
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;

        } else {

            if (node.left == null) {
                Node cur = node.right;
                node = null;//为了优化程序，不写这一步java的垃圾回收机制也会回收的
                size--;
                retNode = cur;

            } else if (node.right == null) {
                Node cur = node.left;
                node = null;
                size--;
                retNode = cur;

            } else {
                Node suc = minimum(node.right);
                suc.right = remove(node.right, suc.key);
                suc.left = node.left;
                node.left = node.right = null;
                retNode = suc;
            }
        }

        if (retNode == null){
            return null;
        }

        //更新点高度值
        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;

        //平衡维护
        if (getBlanceFactor(retNode) > 1 && getBlanceFactor(retNode.left) >= 0){
            //LL情况
            return rightRotate(retNode);
        }else if (getBlanceFactor(retNode) < -1 && getBlanceFactor(retNode.right) <= 0){
            //RR情况
            return leftRotate(retNode);
        }else if (getBlanceFactor(node) > 1 && getBlanceFactor(retNode.left) < 0){
            //LR情况
            retNode.left = leftRotate(retNode.left);
            //即使经过左旋后以node.left为根的树并不满足AVL树的条件再经过对node的右旋后还是会的到以node为根的AVL树
            return rightRotate(retNode);
        }else if (getBlanceFactor(retNode) < -1 && getBlanceFactor(retNode.right) > 0){
            //RL情况
            retNode.right = rightRotate(retNode.right);
            //即使经过右旋后以node.right为根的树并不满足AVL树的条件再经过对node的左旋后还是会的到以node为根的AVL树
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null ? true : false;
    }

    //返回value值
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("node is null");
        node.val = val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
