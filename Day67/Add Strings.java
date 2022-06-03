class Solution {
    public String addStrings(String num1, String num2) {
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int c = 0;
        String ans = "";

        while (a >= 0 || b >= 0 || c != 0) {
            int n1 = a < 0 ? 0 : num1.charAt(a) - '0';
            int n2 = b < 0 ? 0 : num2.charAt(b) - '0';

            int sum = n1 + n2 + c;
            ans = sum % 10 + ans;
            c = sum / 10;
            a--;
            b--;
        }

        return ans;
    }
}