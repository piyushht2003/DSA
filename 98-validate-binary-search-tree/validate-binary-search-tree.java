class Pair {
    long max;
    long min;

    Pair(long max, long min) {
        this.max = max;
        this.min = min;
    }
}

class Solution {
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        maxMin(root);
        return flag;
    }

    Pair maxMin(TreeNode root) {
        if (root == null) return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);

        Pair left = maxMin(root.left);
        Pair right = maxMin(root.right);

        long max = Math.max(root.val, Math.max(left.max, right.max));
        long min = Math.min(root.val, Math.min(left.min, right.min));

        if (left.max >= root.val || right.min <= root.val) flag = false;

        return new Pair(max, min);
    }
}
// class Solution {
//     long prev = Long.MIN_VALUE;

//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return true;
//         // left
//         if (!isValidBST(root.left)) return false;
//         // current
//         if (root.val <= prev)return false;
//         prev = root.val;
//         // right
//         return isValidBST(root.right);
//     }
// }