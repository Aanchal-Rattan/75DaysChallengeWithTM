class LRUCache {

    class Node {
        Node next, prev;
        int value;
        int key;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size, capacity;
    private static Map<Integer, Node> map;
    private static Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node reqNode = map.get(key);
            deleteNode(reqNode);
            addToFront(reqNode);
            return reqNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToFront(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (size < capacity) {
                size++;
                addToFront(newNode);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToFront(newNode);
            }
        }
    }

    public static void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }
}