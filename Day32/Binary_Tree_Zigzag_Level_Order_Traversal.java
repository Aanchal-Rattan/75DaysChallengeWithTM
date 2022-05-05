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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.addFirst(root);
        while (q.size() != 0) {

            List<Integer> l = new ArrayList<>();
            int size = q.size();

            while (size-- > 0) {

                TreeNode temp = q.removeFirst();

                if (temp.left != null)
                    q.addLast(temp.left);
                if (temp.right != null)
                    q.addLast(temp.right);
                l.add(temp.val);

            }
            ans.add(l);

        }

        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }

        return ans;

    }
}