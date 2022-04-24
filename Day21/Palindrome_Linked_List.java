class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        while (!s.isEmpty()) {
            if (head.val != s.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}