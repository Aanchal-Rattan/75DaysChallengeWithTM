class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int val = 0;
        while (true) {
            val = 0;
            while (n > 0) {
                int temp = n % 10;
                val += temp * temp;
                n = n / 10;
            }
            if (val == 1)
                return true;
            else if (set.contains(val))
                return false;

            set.add(val);
            n = val;
        }
    }
}