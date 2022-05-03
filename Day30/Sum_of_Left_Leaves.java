class Solution {
    int sum = 0;

    public void helper(TreeNode root, boolean b) {

        if (root == null)
            return;

        if (root.left == null && root.right == null && b == true) {
            sum += root.val;
        }
        helper(root.left, true);
        helper(root.right, false);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;

    }
}