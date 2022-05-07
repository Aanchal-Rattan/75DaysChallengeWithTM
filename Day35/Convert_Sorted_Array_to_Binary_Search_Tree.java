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

    public TreeNode helper(int[] arr, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;

        TreeNode node = new TreeNode(arr[mid]);
        node.left = helper(arr, l, mid - 1);
        node.right = helper(arr, mid + 1, r);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}