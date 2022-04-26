class Solution {
    public Node flatten(Node head) {
        Node temp = null;
        Node curr = head;
        Stack<Node> st = new Stack<>();

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    st.push(curr.next);
                    curr.next.prev = null;
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            temp = curr;
            curr = curr.next;
        }
        while (!st.isEmpty()) {
            curr = st.pop();
            temp.next = curr;
            curr.prev = temp;
            while (curr != null) {
                temp = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}