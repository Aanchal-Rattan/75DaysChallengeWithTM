/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;

    public void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        if (prev != null) {
            ans = Math.min(ans, Math.abs(prev.val - root.val));
        }
        prev = root;
        helper(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }
}