class Solution {

    public boolean isSame(TreeNode r, TreeNode s) {

        if (r == null && s == null)
            return true;

        if ((r == null && s != null) || (r != null && s == null)) {
            return false;
        }

        if (r.val != s.val)
            return false;

        return isSame(r.left, s.left) && isSame(r.right, s.right);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null)
            return subRoot == null;

        if (root.val == subRoot.val && isSame(root, subRoot) == true)
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

}