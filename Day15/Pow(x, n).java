class Solution {
    public double myPow(double x, int n) {

        if (n < 0) {

            x = 1 / x;
        }
        return func(x, n);

    }

    public double func(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = func(x, n / 2);
        return (n % 2 == 0 ? ans * ans : x * ans * ans);
    }
}