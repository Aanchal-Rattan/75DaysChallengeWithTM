class Solution {

    public int myAtoi(String s) {
        int i = 0;
        // spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        // number
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 ||
                    num * 10 > Integer.MAX_VALUE - (s.charAt(i) - '0')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }
        return num * sign;
    }
}