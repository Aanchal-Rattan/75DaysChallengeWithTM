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
    // si --> pre starting idx, ei --> pre ending idx , psi --> post starting idx,
    // pei --> post ending idx, te = total elements

    public TreeNode helper(int[] pre, int si, int ei, int[] post, int psi, int pei) {

        if (si > ei)
            return null;

        TreeNode root = new TreeNode(pre[si]);
        if (si == ei)
            return root;

        int idx = psi;
        while (post[idx] != pre[si + 1])
            idx++;

        int te = idx - psi + 1;

        root.left = helper(pre, si + 1, si + te, post, psi, idx);
        root.right = helper(pre, si + te + 1, ei, post, idx + 1, pei);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        int n = preorder.length;
        return helper(preorder, 0, n - 1, postorder, 0, n - 1);
    }
}