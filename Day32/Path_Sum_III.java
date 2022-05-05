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

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        helper(root, 0, targetSum, map);

        return ans;
    }

    public void helper(TreeNode root, int sum, int tar, HashMap<Integer, Integer> map) {

        if (root == null)
            return;
        sum += root.val;

        if (map.containsKey(sum - tar)) {
            ans += map.get(sum - tar);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, sum, tar, map);
        helper(root.right, sum, tar, map);

        map.put(sum, map.get(sum) - 1);
        return;
    }
}
