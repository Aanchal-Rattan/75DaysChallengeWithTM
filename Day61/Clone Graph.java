/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public HashMap<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        visited.put(copy.val, copy);
        for (Node n : node.neighbors) {
            Node neighborCopy;
            if (visited.containsKey(n.val)) {
                neighborCopy = visited.get(n.val);
            } else {
                neighborCopy = cloneGraph(n);
            }
            copy.neighbors.add(neighborCopy);
        }
        return copy;
    }
}