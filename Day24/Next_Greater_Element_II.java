class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= arr[i])
                st.pop();

            st.push(arr[i]);
        }

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= arr[i])
                st.pop();
            ans[i] = st.size() == 0 ? -1 : st.peek();
            st.push(arr[i]);
        }

        return ans;
    }
}