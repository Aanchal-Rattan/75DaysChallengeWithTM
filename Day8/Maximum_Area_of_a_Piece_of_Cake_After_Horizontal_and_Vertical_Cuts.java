class Solution {

    public static int max(ArrayList<Integer> list) {
        int m = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1);
            int b = list.get(i);

            m = Math.max(m, b - a);
        }

        return m;
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        ArrayList<Integer> hi = new ArrayList<>();
        hi.add(0);
        hi.add(h);
        ArrayList<Integer> wi = new ArrayList<>();
        wi.add(0);
        wi.add(w);

        for (int a : horizontalCuts) {
            hi.add(a);
        }
        for (int b : verticalCuts) {
            wi.add(b);
        }
        Collections.sort(hi);
        Collections.sort(wi);

        int x = max(hi);
        int y = max(wi);

        return (int) ((1L * x * y) % 1000000007); // 1L for long
    }
}