class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static int maxMeetings(int start[], int end[], int n) {
        int count = 1;

        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.end - p2.end;
            }
        });

        int recentEnded = arr[0].end;

        for (int i = 1; i < n; i++) {
            if (arr[i].start > recentEnded) {
                count++;
                recentEnded = arr[i].end;
            }
        }

        return count;
    }
}