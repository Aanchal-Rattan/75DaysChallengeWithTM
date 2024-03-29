public class Solution {
    public ListNode detectCycle(ListNode head) {

        if ((head == null) || (head.next == null))
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;

                }
                return fast;
            }
        }
        return null;
    }
}