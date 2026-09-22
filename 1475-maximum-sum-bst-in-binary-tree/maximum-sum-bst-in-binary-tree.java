class Solution {

    int ans = 0;

    class Sum {
        boolean isBST;
        int min;
        int max;
        int sum;

        Sum(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public Sum helper(TreeNode root) {

        if (root == null) {
            return new Sum(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Sum left = helper(root.left);
        Sum right = helper(root.right);

        if (left.isBST && right.isBST &&
            left.max < root.val && root.val < right.min) {

            int sum = left.sum + root.val + right.sum;

            ans = Math.max(ans, sum);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Sum(true, min, max, sum);
        }

        return new Sum(false, 0, 0, 0);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}