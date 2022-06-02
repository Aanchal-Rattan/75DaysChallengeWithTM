class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] dp = new int[k + 1][n];

        for (int stops = 0; stops <= k; stops++) {
            for (int city = 0; city < n; city++) {
                if (city == src)
                    dp[stops][city] = 0;
                else
                    dp[stops][city] = Integer.MAX_VALUE;
            }
        }
        for (int[] flight : flights) {
            int source = flight[0], dest = flight[1], cost = flight[2];
            if (source == src)
                dp[0][dest] = cost;
        }

        for (int stops = 1; stops <= k; stops++) {

            for (int city = 0; city < n; city++)
                dp[stops][city] = dp[stops - 1][city];

            for (int[] flight : flights) {

                int source = flight[0], dest = flight[1], cost = flight[2];

                if (dp[stops - 1][source] == Integer.MAX_VALUE)
                    continue;

                if (dp[stops - 1][source] + cost < dp[stops][dest]) {
                    dp[stops][dest] = dp[stops - 1][source] + cost;
                }
            }

        }

        return dp[k][dst] == Integer.MAX_VALUE ? -1 : dp[k][dst];
    }
}