class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += cardPoints[i];
        int max = sum;
        int i = cardPoints.length;
        while (k > 0) {
            sum = sum + cardPoints[--i] - cardPoints[--k];
            max = Math.max(max, sum);
        }
        return max;
    }
}