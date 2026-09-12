// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int n = inorder.length;
//         return build(0,n-1,0,n-1,inorder,preorder);
//     }
//     public static TreeNode build(int preLo, int preHi, int inLo, int inHi, int inorder[], int preorder[]) {
//         if(preLo > preHi || inLo > inHi) return null;
//         int val = preorder[preLo];
//         TreeNode root = new TreeNode(val);
//         int r = 0;
//         for(int i=inLo;i<=inHi;i++){ // locating root in inorder array
//             if(inorder[i]==val){
//                 r = i;
//                 break;
//             }
//         }
//         int cnt = r - inLo; // Number of elements in LST
//         root.left = build(preLo+1,preLo+cnt,inLo,r-1,inorder,preorder);
//         root.right = build(preLo+cnt+1,preHi,r+1,inHi,inorder,preorder);
//         return root;
//     }
// }
class Solution {
    int pre = 0;
    int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return BST(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode BST(int[] preorder, int[] inorder, int limit){
        if(pre >= preorder.length) return null;
        if(inorder[in] == limit){
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = BST(preorder, inorder, root.val);
        root.right = BST(preorder, inorder, limit);
        return root;
    }
}