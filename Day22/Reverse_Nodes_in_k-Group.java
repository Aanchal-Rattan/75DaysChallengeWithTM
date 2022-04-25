class Solution {

    public ListNode reverse(ListNode head, int k, int c) {

        if (c < k)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode n = null;

        int i = 0;
        while (i < k && curr != null) {

            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
            i++;

        }

        if (n != null)
            head.next = reverse(n, k, c - k);

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // length
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }

        return reverse(head, k, c);
    }
}