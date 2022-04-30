class Solution {
    int ans = 0;

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;

    }
}