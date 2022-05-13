class Solution {

    public int helper(ArrayList<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() == 0) {
            return 0;
        }

        int a = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        int b = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        list.add(Math.abs(a - b));
        Collections.sort(list);

        return helper(list);

    }

    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        Collections.sort(list);

        return helper(list);
    }
}