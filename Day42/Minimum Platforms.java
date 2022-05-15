class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int Platforms = 1;
        int ans = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                Platforms++;
                i++;
            } else if (arr[i] > dep[j]) {
                Platforms--;
                j++;
            }

            if (Platforms > ans) {
                ans = Platforms;
            }
        }
        return ans;
    }

}
