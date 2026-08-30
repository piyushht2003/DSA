/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exists(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) return true;
        return exists(root.left, target) || exists(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        boolean pLiesInLeft = exists(root.left, p);
        boolean qLiesInLeft = exists(root.left, q);

        // Dono left me hain -> left jao
        if (pLiesInLeft && qLiesInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Dono right me hain -> right jao
        else if (!pLiesInLeft && !qLiesInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Ek left me aur ek right me -> root hi LCA hai
        else {
            return root;
        }
    }
}