/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();

    }

    static int idx = 0;

    public TreeNode deserializeHelper(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            ;
            return null;
        }

        TreeNode temp = new TreeNode(Integer.parseInt(arr[idx++]));
        temp.left = deserializeHelper(arr);
        temp.right = deserializeHelper(arr);

        return temp;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return deserializeHelper(arr);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));