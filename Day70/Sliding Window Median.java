class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        final int len = nums.length;
        final double[] medians = new double[len - (k - 1)];

        int medianPtr = 0;
        final List<Integer> window = new ArrayList<>();
        int nextNumPtr = 0;
        for (int i = 0; i < k; i++) {
            window.add(nums[nextNumPtr++]);
        }
        medians[medianPtr++] = findMedian(window);

        for (int windowStart = 1; windowStart < medians.length; windowStart++) {
            window.set(window.indexOf(nums[windowStart - 1]), nums[nextNumPtr++]);
            medians[medianPtr++] = findMedian(window);
        }
        return medians;
    }

    private double findMedian(List<Integer> source) {
        Collections.sort(source);
        final int mid = source.size() / 2;
        if (source.size() % 2 == 1) {
            return source.get(mid);
        } else {
            return ((double) source.get(mid - 1) + (double) source.get(mid)) / 2d;
        }
    }
}