class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        int size = 0;

        while (slow != null) {
            size++;
            slow = slow.next;
        }

        slow = head;

        if (size - n == 0)
            return head.next;

        int x = n;
        while (x-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;
        return head;
    }
}