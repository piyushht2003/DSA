class Twin {
    int max;
    int min;

    Twin(int max, int min) {
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

    Twin maxMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        Twin left = maxMin(root.left);
        Twin right = maxMin(root.right);

        if (left != null && root.val <= left.max) {
            flag = false;
        }

        if (right != null && root.val >= right.min) {
            flag = false;
        }

        int max = root.val;
        int min = root.val;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }

        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }

        return new Twin(max, min);
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