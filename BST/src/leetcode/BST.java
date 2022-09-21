package leetcode;

public class BST {
    public TreeNode root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public void add(int e){
       root = add(root,e);
    }

    private TreeNode add(TreeNode node,int e){
        if(node == null){
            size++;
            return new TreeNode(e);
        }


        if(e < node.val)
            node.left = add(node.left,e);
        else if(e > node.val)
            node.right = add(node.right,e);

        return node;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode node){
        if(node == null)
            return;

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }


}

