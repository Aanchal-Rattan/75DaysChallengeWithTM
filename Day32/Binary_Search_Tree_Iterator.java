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
class BSTIterator {

    TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        this.curr = root;
    }

    private TreeNode getRightMostElement(TreeNode r) {
        while (r.right != null && r.right != this.curr)
            r = r.right;
        return r;
    }

    private TreeNode morrisTraversal() {
        TreeNode res = null;

        while (this.curr != null) {
            TreeNode leftNode = this.curr.left;
            if (leftNode == null) {
                res = this.curr;
                this.curr = curr.right;
                break;
            } else {
                // rmn = rigth most node
                TreeNode rmn = getRightMostElement(leftNode);
                if (rmn.right == null) {
                    rmn.right = this.curr;
                    this.curr = this.curr.left;
                } else {
                    res = this.curr;
                    rmn.right = null;
                    this.curr = this.curr.right;
                    break;

                }

            }
        }
        return res;
    }

    public int next() {
        TreeNode res = morrisTraversal();
        return res.val;
    }

    public boolean hasNext() {
        return this.curr != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */