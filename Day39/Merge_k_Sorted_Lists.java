/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (!pq.isEmpty()) {
            head.next = new ListNode(pq.poll());
            head = head.next;
        }

        return dummy.next;
    }
}