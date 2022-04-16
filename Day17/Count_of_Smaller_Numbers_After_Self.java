class Solution {

    public int binarySearch(List<Integer> arr, int k) {
        int l = 0;
        int r = arr.size() - 1;
        ;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr.get(mid) < k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (arr.get(l) == k)
            return l;
        return mid;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : nums)
            arr.add(i);

        Collections.sort(arr);

        for (int i : nums) {
            int idx = binarySearch(arr, i);
            ans.add(idx);
            arr.remove(idx);
        }

        return ans;
    }
}