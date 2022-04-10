public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        Set<Integer> set = map.getOrDefault(val, new LinkedHashSet<Integer>());
        boolean notPresent = set.isEmpty();
        if (notPresent) {
            map.put(val, set);
        }
        set.add(list.size());
        list.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        Set<Integer> set = map.get(val);
        if (set == null || set.isEmpty())
            return false;
        int removeIdx = set.iterator().next();
        set.remove(removeIdx);
        int lastVal = list.get(list.size() - 1);
        list.set(removeIdx, lastVal);
        Set<Integer> lastSet = map.get(lastVal);
        lastSet.add(removeIdx);
        lastSet.remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}