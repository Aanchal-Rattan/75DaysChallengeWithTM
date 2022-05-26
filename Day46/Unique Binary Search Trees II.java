/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return builder(1,n);
    }
    public List<TreeNode> builder(int start,int end) {
        List<TreeNode> ans = new ArrayList<>();
        if(start>=end) {
            TreeNode root = new TreeNode(start);
            if(start==end)
            ans.add(root);
            else ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++) {
            
            List<TreeNode> left = builder(start,i-1);
            List<TreeNode> right = builder(i+1,end);
            for(TreeNode j:left) {
                for(TreeNode k:right) {
                    TreeNode root = new TreeNode(i);
                    root.left = j;
                    root.right =k;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}