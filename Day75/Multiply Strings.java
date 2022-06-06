class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] dp = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int high = i + j;
                int low = high + 1;
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int sum = dp[high] * 10 + dp[low] + a * b;
                dp[high] = sum / 10;
                dp[low] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : dp) {
            if (sb.length() == 0 && i == 0) {
                continue;
            } else {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}