class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        int ans = Integer.MIN_VALUE;
        for(int[] point : points) {
            while(!maxHeap.isEmpty() && point[0] - maxHeap.peek().getValue() > k) {
                maxHeap.poll();
            }
            if(!maxHeap.isEmpty()) {
                ans = Math.max(ans, point[0] + point[1] + maxHeap.peek().getKey());
            }
            maxHeap.offer(new Pair<Integer, Integer>(point[1] - point[0], point[0]));
        }
        return ans;
    }
}