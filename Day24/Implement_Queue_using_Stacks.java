class MyQueue {

    Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        int ans = temp.pop();
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return ans;
    }

    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        int ans = temp.peek();
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return ans;
    }

    public boolean empty() {
        return st.isEmpty();
    }
}