class ItemCompare implements Comparator<Item> {
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 < r2)
            return 1;
        else if (r1 > r2)
            return -1;
        else
            return 0;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new ItemCompare());

        double ans = 0.0;
        int currw = 0;

        for (int i = 0; i < n; i++) {
            if (currw + arr[i].weight <= W) {
                ans += arr[i].value;
                currw += arr[i].weight;
            } else {
                int diff = W - currw;
                ans += ((double) arr[i].value / (double) arr[i].weight) * (double) diff;
                break;
            }
        }
        return ans;

    }
}