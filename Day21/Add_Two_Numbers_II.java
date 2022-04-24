class Solution {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode nextNode = null;
        ListNode curr = head;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        int c = 0;

        while (l1 != null || l2 != null || c != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + c;
            int res = sum % 10;
            c = sum / 10;

            temp.next = new ListNode(res);
            temp = temp.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        temp.next = null;
        return reverse(ans.next);

    }
}