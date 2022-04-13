class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}