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
    int ans;
    int k;

    public void inorder(TreeNode root) {

        if (root == null || k <= 0)
            return;

        inorder(root.left);

        if (this.k > 0)
            ans = root.val;

        this.k--;

        if (this.k > 0)
            inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }
}