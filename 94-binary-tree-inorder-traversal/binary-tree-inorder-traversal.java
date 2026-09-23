class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode p = curr.left;
                while(p.right!=null && p.right!=curr) p = p.right;
                if(p.right==null){
                    p.right = curr;
                    curr = curr.left;
                }
                else{
                    p.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
                ans.add(curr.val);
                curr = curr.right;
            }
        }
       return ans; 
    }
}

// // -> RECURSION
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        dfs(root, ans);
//        return ans; 
//     }
//     public void dfs(TreeNode root, ArrayList<Integer> ans) {
//        if(root==null) return;
//        dfs(root.left, ans);
//        ans.add(root.val);
//        dfs(root.right, ans);
//     }
// }
// class Solution { // -> Iterative 
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode curr = root;
//         while(st.size()>0 || curr!=null){
//             if(curr!=null){
//                 if(curr.left!=null){
//                     st.push(curr);
//                     curr = curr.left;
//                 }
//                 else{
//                     ans.add(curr.val);
//                     curr = curr.right;
//                 }
//             }
//             else{
//                 TreeNode top = st.pop();
//                 ans.add(top.val);
//                 curr = top.right;
//             }
//         }
//         return ans;
//     }
// }
// }