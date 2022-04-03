class RandomizedSet {
    List<Integer> list;
    Random r;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int remidx = map.get(val);
        map.remove(val);

        if (remidx == list.size() - 1) {
            list.remove(remidx);
            return true;
        }

        list.set(remidx, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        map.put(list.get(remidx), remidx);
        return true;
    }

    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);

    }
}
