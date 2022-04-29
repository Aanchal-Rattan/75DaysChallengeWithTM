class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        for (i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }

        for (; i < nums.length; i++) {
            list.add(nums[dq.peek()]);

            while (!dq.isEmpty() && dq.peek() <= i - k)
                dq.removeFirst();

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        list.add(nums[dq.peek()]);

        return list.stream().mapToInt(ele -> ele).toArray();
    }
}