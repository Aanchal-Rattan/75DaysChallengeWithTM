class Solution {
    ArrayList<String> list = new ArrayList<>();

    public void helper(TreeNode root, String s) {
        if (root == null)
            return;

        if (s.length() == 0)
            s += root.val;
        else
            s = s + "->" + root.val;

        if (root.left == null && root.right == null)
            list.add(s);

        helper(root.left, s);
        helper(root.right, s);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        helper(root, s);
        return list;
    }
}