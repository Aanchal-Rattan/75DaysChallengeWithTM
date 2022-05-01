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