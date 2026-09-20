class Solution {
    static int sum;
    public void revInorder(TreeNode root) {
        if(root==null) return;
        revInorder(root.right);
        sum += root.val;
        root.val = sum;
        revInorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        revInorder(root);
        return root;
    }
}
// class Solution {
//     public static void inorder(TreeNode root, ArrayList<TreeNode> arr ) {
//         if(root==null) return;
//         inorder(root.left, arr);
//         arr.add(root);
//         inorder(root.right, arr);
//     }
//     public TreeNode bstToGst(TreeNode root) {
//         ArrayList<TreeNode> arr = new ArrayList<>();
//         inorder(root, arr);
//         Collections.reverse(arr);
//         int sum = 0;
//         for(int i = 0; i<arr.size(); i++){
//             sum += arr.get(i).val;
//             arr.get(i).val = sum;
//         }
//         return root;
//     }
// }