class TimeMap {

    class Value {
        String v;
        Integer t;

        public Value(String v, Integer time) {
            this.v = v;
            this.t = time;
        }

    }

    Map<String, List<Value>> m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        m.putIfAbsent(key, new ArrayList<>());
        m.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) {
            return "";
        }
        List<Value> values = m.get(key);
        int l = 0;
        int r = values.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            Value mid = values.get(m);
            if (mid.t == timestamp) {
                // return mid.v;
                res = mid.v;
                break;
            } else if (mid.t < timestamp) {
                res = mid.v;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}