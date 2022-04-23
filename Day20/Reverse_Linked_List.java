class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode n = null;
        
        while(curr!=null ){
          n = curr.next;
          curr.next = prev;
            prev = curr;
            curr = n ;
            
        }
        return prev;
        
    }
}