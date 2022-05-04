/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<>();
        findPath(root, target);
        for (int i = 0; i < path.size(); i++) {
            TreeNode blocker = i == 0 ? null : path.get(i - 1);
            kLevelDown(path.get(i), k - i, blocker);
        }
        return ans;
    }

    // to find the path node to root
    List<TreeNode> path = new ArrayList<>();

    public Boolean findPath(TreeNode root, TreeNode target) {

        if (root == null)
            return false;

        if (root == target) {
            path.add(root);
            return true;
        }

        Boolean left = findPath(root.left, target);
        if (left) {
            path.add(root);
            return true;
        }
        Boolean right = findPath(root.right, target);
        if (right) {
            path.add(root);
            return true;
        }

        return false;
    }

    // to add the k distance node in the list
    List<Integer> ans = new ArrayList<>();

    public void kLevelDown(TreeNode root, int k, TreeNode blocker) {

        if (root == null || k < 0 || root == blocker) {
            return;
        }
        if (k == 0)
            ans.add(root.val);
        kLevelDown(root.left, k - 1, blocker);
        kLevelDown(root.right, k - 1, blocker);
    }
}
