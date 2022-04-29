class LFUCache {
    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 0;
        }
    }

    class DLList {
        Node head;
        Node tail;
        int len;

        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            len = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node node) {
            Node next = head.next;
            node.next = next;
            node.prev = head;
            next.prev = node;
            head.next = node;
            len++;
        }

        // removes the LRU
        public Node removeTail() {
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len--;
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        if (map.get(key) == null)
            return -1;
        Node node = map.get(key);
        DLList curList = freqMap.get(node.freq);
        curList.remove(node);
        if (curList.len == 0) {
            freqMap.remove(node.freq);
            if (node.freq == minFreq) {
                minFreq++;
            }
        }
        node.freq++;
        DLList nextList = freqMap.getOrDefault(node.freq, new DLList());
        nextList.addHead(node);
        freqMap.putIfAbsent(node.freq, nextList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            get(key);
            return;
        }

        if (map.size() == capacity) {
            DLList leastfreqList = freqMap.get(minFreq);
            Node toDelete = leastfreqList.removeTail();
            map.remove(toDelete.key);
            if (leastfreqList.len == 0) {
                freqMap.remove(minFreq);
            }
        }
        Node node = new Node(key, value);
        node.freq = 1;
        map.put(key, node);

        DLList curList = freqMap.getOrDefault(1, new DLList());
        curList.addHead(node);
        minFreq = 1;
        freqMap.putIfAbsent(minFreq, curList);
    }
}