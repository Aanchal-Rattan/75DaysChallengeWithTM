class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        int c = 1;

        while (temp.next != null) {
            temp = temp.next;
            c++;
        }
        temp.next = head;

        k = k % c;
        if (k < 0) {
            k = k + c;
        }

        int steps = c - k;

        while (steps-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;

    }
}