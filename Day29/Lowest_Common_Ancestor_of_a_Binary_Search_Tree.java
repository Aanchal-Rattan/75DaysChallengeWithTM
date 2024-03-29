class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode d1, TreeNode d2) {
        if (node == null)
            return null;

        if (d1.val < node.val && d2.val < node.val) {
            // lca exist in left
            return lowestCommonAncestor(node.left, d1, d2);
        } else if (d1.val > node.val && d2.val > node.val) {
            // lca exist in right
            return lowestCommonAncestor(node.right, d1, d2);
        } else {
            // node is LCA
            return node;
        }

    }
}