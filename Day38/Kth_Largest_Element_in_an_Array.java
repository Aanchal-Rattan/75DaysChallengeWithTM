class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // make pq of k elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // iterate and compare the min element of pq with array
        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        // push all the elements of pq in stack
        Stack<Integer> st = new Stack<>();
        while (pq.size() > 0) {
            st.push(pq.remove());
        }

        int ans = 0;
        // pop k elements to obtain the kth largest element
        for (int i = 0; i < k; i++)
            ans = st.pop();

        return ans;

    }
}