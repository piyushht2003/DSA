class Pair {
    TreeNode node;
    int lvl;

    Pair(TreeNode node, int lvl) {
        this.node = node;
        this.lvl = lvl;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int currLvl = p.lvl;

            // Create a new inner list if we reached a new level
            if (ans.size() == currLvl) {
                ans.add(new ArrayList<>());
            }

            // Add node value to the current level's list
            ans.get(currLvl).add(node.val);

            // Push children to the queue with incremented level
            if (node.left != null) {
                q.add(new Pair(node.left, currLvl + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, currLvl + 1));
            }
        }

        return ans;
    }
}