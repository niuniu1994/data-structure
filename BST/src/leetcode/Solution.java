package leetcode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        else t1.val += t2.val;

        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    public static void main(String[] args){
        BST bst = new BST();
        BST bst1 = new BST();
        for(int i = 0;i < 10; i++){
            bst.add(i);
        }

        for(int i = 0; i < 5;i++)
            bst1.add(i);

        Solution s = new Solution();
        s.mergeTrees(bst1.root,bst.root);
        bst1.preOrder();
    }
}
