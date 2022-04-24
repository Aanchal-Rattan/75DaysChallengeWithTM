public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;

        ListNode t1 = headA;
        while (t1 != null) {
            l1++;
            t1 = t1.next;
        }
        ListNode t2 = headB;
        while (t2 != null) {
            l2++;
            t2 = t2.next;
        }
        int diff = Math.abs(l1 - l2);
        t1 = headA;
        t2 = headB;
        if (l1 < l2) {
            while (diff-- > 0) {
                t2 = t2.next;
            }
        } else {
            while (diff-- > 0) {
                t1 = t1.next;
            }
        }
        System.out.println(t1.val);
        System.out.println(t2.val);
        while (t1 != null && t2 != null) {
            System.out.println(t1.val);
            if (t1.val == t2.val && t1 == t2) {
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        return null;

    }
}