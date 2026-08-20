class Solution {
    public boolean isSymmetric(TreeNode root) {
        mirror(root.left);
        return isIdentical(root.left, root.right);
    }
    boolean isIdentical(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
    void mirror(TreeNode root) {
        if(root==null) return;
        TreeNode temp = root.left; 
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}