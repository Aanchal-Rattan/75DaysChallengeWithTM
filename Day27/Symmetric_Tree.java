class Solution {

    public boolean helper(TreeNode l, TreeNode r) {
        if (r == null && l == null)
            return true;
        if ((r == null && l != null) || (l == null && r != null))
            return false;

        return (l.val == r.val) && helper(l.left, r.right) && helper(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
}