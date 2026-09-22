class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}

// class Pair {
//     long max;
//     long min;

//     Pair(long max, long min) {
//         this.max = max;
//         this.min = min;
//     }
// }

// class Solution {
//     boolean flag;

//     public boolean isValidBST(TreeNode root) {
//         flag = true;
//         maxMin(root);
//         return flag;
//     }

//     Pair maxMin(TreeNode root) {
//         if (root == null) return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);

//         Pair left = maxMin(root.left);
//         Pair right = maxMin(root.right);

//         long max = Math.max(root.val, Math.max(left.max, right.max));
//         long min = Math.min(root.val, Math.min(left.min, right.min));

//         if (left.max >= root.val || right.min <= root.val) flag = false;

//         return new Pair(max, min);
//     }
// }
