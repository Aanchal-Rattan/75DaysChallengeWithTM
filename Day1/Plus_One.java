class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1;
        int size = digits.length;

        int[] ans = new int[size + 1];
        int idx = ans.length - 1;

        if (digits[size - 1] != 9) {
            digits[size - 1] += 1;
            return digits;

        }
        int i = size - 1;
        while (i >= 0) {
            int temp = carry + digits[i];
            ans[idx] = temp % 10;
            carry = temp / 10;
            i--;
            idx--;
        }

        if (carry != 0) {
            ans[idx] = carry;
        }

        if (ans[0] == 0) {
            idx = 0;
            int[] ans2 = new int[ans.length - 1];
            for (int j = 1; j < ans.length; j++) {
                ans2[idx] = ans[j];
                idx++;
            }
            return ans2;
        }
        return ans;

    }
}