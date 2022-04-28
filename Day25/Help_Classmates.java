class Solution {
    public static int[] help_classmate(int arr[], int n) {
        // Your code goes here
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (st.size() > 0 && st.peek() >= arr[i])
                st.pop();

            ans[i] = st.size() == 0 ? -1 : st.peek();
            st.push(arr[i]);

        }
        return ans;
    }
}