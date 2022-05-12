class Solution {

    class pair_sorted implements Comparable<pair_sorted> {

        int sp;
        int ht;

        pair_sorted(int sp, int ht) {
            this.sp = sp;
            this.ht = ht;
        }

        public int compareTo(pair_sorted p) {

            if (this.sp == p.sp) {

                return p.ht - this.ht;
            }
            return this.sp - p.sp;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li;

        if (buildings.length <= 0)
            return ans;

        int changedheight = 0;
        int peekedmax = 0;
        PriorityQueue<pair_sorted> pq = new PriorityQueue<>();
        start_height_end_height_sorted(buildings, pq);

        int si = pq.size();
        PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder());
        mpq.add(0);

        int sz = pq.size();
        for (int i = 0; i < sz; i++) {
            li = new ArrayList<>();
            pair_sorted rem = pq.remove();

            if (rem.ht > 0) {
                mpq.add(rem.ht);
                peekedmax = mpq.peek();
                if (changedheight < peekedmax) {
                    changedheight = peekedmax;
                    li.add(rem.sp);
                    li.add(peekedmax);
                }
            }

            else if (rem.ht < 0) {
                int rv = 0 - rem.ht;
                mpq.remove(rv);

                peekedmax = mpq.peek();

                if (changedheight > peekedmax) {
                    changedheight = peekedmax;
                    li.add(rem.sp);
                    li.add(peekedmax);

                }
            }

            if (li.size() == 2)
                ans.add(li);
        }
        return ans;
    }

    private void start_height_end_height_sorted(int[][] buildings, PriorityQueue<pair_sorted> pq) {
        for (int i = 0; i < buildings.length; i++) {
            int sp = buildings[i][0];
            int ep = buildings[i][1];
            int ht = buildings[i][2];
            pq.add(new pair_sorted(sp, ht));
            ht = -ht;
            pq.add(new pair_sorted(ep, ht));
        }
    }
}