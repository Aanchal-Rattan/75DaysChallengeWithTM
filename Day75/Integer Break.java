class Solution {
    public int integerBreak(int n) {
        int i = n % 2 == 0 ? n / 2 : n / 2 + 1;
        return brk(n, 1, i);
    }

    public int brk(int n, int p, int i) {

        if (n < 0 || i < 1)
            return 1;
        if (n == 0)
            return p;
        int k = 0;
        if (n - i >= 0)
            k = brk(n - i, p * i, i);
        k = Math.max(k, brk(n, p, i - 1));
        return k;
    }
}