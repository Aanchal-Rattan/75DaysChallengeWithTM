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

    public static class pair {
        TreeNode node = null;
        int idx = 0;

        pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        LinkedList<pair> q = new LinkedList<>();
        int max = 0;
        q.addLast(new pair(root, 0));

        while (q.size() != 0) {
            int size = q.size();
            int l = q.getFirst().idx;
            int r = q.getFirst().idx;
            while (size-- > 0) {
                pair temp = q.removeFirst();

                r = temp.idx;

                if (temp.node.left != null)
                    q.addLast(new pair(temp.node.left, temp.idx * 2 + 1));
                if (temp.node.right != null)
                    q.addLast(new pair(temp.node.right, temp.idx * 2 + 2));

            }

            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
