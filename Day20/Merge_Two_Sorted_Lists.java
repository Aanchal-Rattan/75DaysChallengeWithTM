class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode l = null;
        ListNode head = null;

        if (list1.val <= list2.val) {
            l = head = list1;
            list1 = list1.next;

        } else {
            l = head = list2;
            list2 = list2.next;

        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                l.next = list1;
                list1 = list1.next;
                l = l.next;
            } else {
                l.next = list2;
                list2 = list2.next;
                l = l.next;
            }
        }
        if (list1 != null) {
            while (list1 != null) {
                l.next = list1;
                list1 = list1.next;
                l = l.next;
            }
        }
        if (list2 != null) {
            l.next = list2;
            list2 = list2.next;
            l = l.next;
        }
        return head;
    }
}