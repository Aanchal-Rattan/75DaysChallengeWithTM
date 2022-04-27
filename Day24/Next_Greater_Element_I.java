class Solution {

    public static int[] nextGreater(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < arr[i])
                st.pop();
            ans[i] = st.size() == 0 ? -1 : st.peek();
            st.push(arr[i]);
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }

        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] temp = nextGreater(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], temp[i]);
        }

        int res[] = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}