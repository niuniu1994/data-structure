import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        /*if(root == null){
            root = new Node(e);
            size++;/*
        }else{
            add(root,e)
        }*/
        root = add(root, e);
    }

    //向以node为根的二叉树中加入新元素e
    private Node add(Node node, E e) {
       /* if(e.equals(node.e))
            return;
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }*/
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    private boolean contain(E e) {
        return find(root, e) ? true : false;
    }

    private boolean find(Node node, E e) {
       /* if(e.equals(node.e))
            return e;
        else if(e.compareTo(node.e) > 0 && node.right == null)
            return null;
        else if(e.compareTo(node.e) < 0 && node.left == null)
            return null;

        if (e.compareTo(node.e) > 0)
            return find(node.right,e);
        else
            return find(node.left, e);*/
        if (node == null)
            return false;
        if (e.equals(node.e))
            return true;

        if (e.compareTo(node.e) > 0)
            return find(node.right, e);
        else
            return find(node.left, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二叉树，递归算法,最常见的遍历法
    private void preOrder(Node node) {

        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //用栈实现前序遍历
    private void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.println(node.e);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

        }

    }

    public void inOrder() {
        inOrder(root);
    }

    //二分搜索树的中序遍历，得出结果是从小到大排列的
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void inOrderNR() {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() && node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (node.right != null)
                node = node.right;
            else node = stack.pop();
        }

    }

    public void postOrder() {
        postOrderNR();
    }

    //二分搜索树的后序遍历递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);


    }

    private void postOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        Node pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 下面，我们看，对于这个cur，要不要遍历右边？
            // 有两种情况，不需要遍历右边
            // 一种情况是，根本就没有右子树（cur->right == nullptr）
            // 另一种情况是，右边已经遍历过了。
            // 根据后序遍历的性质，如果右边已经遍历过了，一定是上一次遍历的结果
            // 所以存在了temp中
            Node cur = stack.peek();
            if (cur.right == null || pre == cur.right) {
                stack.pop();
                pre = cur;
                System.out.print(cur.e + " ");
            } else {
                node = cur.right;
            }
        }
    }

    public void levalOrder() {
        Queue<Node> queue = new LinkedList<>();
        Node node = root;

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }

    }

    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("the tree is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node minimumNR(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("the tree is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.left == null)
            return node;
        else return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中最小的节点
    //返回删除节点后新的二分搜索树的根 因为有时候根就是最小节点 删除后根就根就会改变
    //所以有删除元素的的操作都要考虑根的变化。
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rNode = node.right;
            size--;
            return rNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMin(node.right);
        size--;
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else {

            if (node.left == null) {
                Node cur = node.right;
                node.right = null;//为了优化程序，不写这一步java的垃圾回收机制也会回收的
                size--;
                return cur;
            }

            if (node.right == null) {
                Node cur = node.left;
                node.left = null;
                size--;
                return cur;
            }

            //当node 左右都还有节点时
            //我们就要找到右子树最小的节点来代替被删除的节点
            Node suc = minimum(node.right);
            suc.right = removeMin(node.right);
            suc.left = node.left;
            return suc;

        }

    }


    public Boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepth(depth) + " null\n");
            return;
        }
        res.append(generateDepth(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepth(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public int feuille(){
        return feuilee(root);
    }

    private int feuilee(Node node){
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        /*
        if(node.left == null)
            return feuilee(node.right);
        if(node.right == null)
            return feuilee(node.left);
         */

        return feuilee(node.left) + feuilee(node.right);
    }
}
