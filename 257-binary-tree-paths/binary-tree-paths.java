class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root, arr, ans);
        return ans;
    }

    public static void dfs(TreeNode root, ArrayList<Integer> arr, List<String> ans) {
        if (root == null) return;

        arr.add(root.val);

        // Leaf node reached: build the "->" separated string
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i));
                if (i < arr.size() - 1) {
                    sb.append("->");
                }
            }
            ans.add(sb.toString());
            arr.remove(arr.size() - 1);
            return;
        }

        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);

        // Backtrack
        arr.remove(arr.size() - 1);
    }
}