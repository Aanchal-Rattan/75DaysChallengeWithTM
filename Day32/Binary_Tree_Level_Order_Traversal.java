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
    public List<List<Integer>> levelOrder(TreeNode node) {

        List<List<Integer>> ans = new ArrayList<>();

        if (node == null)
            return ans;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(node);

        while (q.size() > 0) {

            int count = q.size();
            List<Integer> temp = new ArrayList<>();

            while (count-- > 0) {

                TreeNode n = q.removeFirst();
                temp.add(n.val);

                if (n.left != null) {
                    q.addLast(n.left);
                }
                if (n.right != null) {
                    q.addLast(n.right);
                }

            }

            ans.add(temp);
        }
        return ans;
    }
}