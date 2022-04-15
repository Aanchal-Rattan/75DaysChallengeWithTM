class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (nums2.length < nums1.length) {
            A = nums2;
            B = nums1;
        }
        if (A.length == 0) {
            int mid = B.length / 2;
            if (B.length % 2 == 1) {
                return (double) B[mid];
            } else {
                return ((double) B[mid - 1] + (double) B[mid]) / 2;
            }
        }

        int total = nums1.length + nums2.length;
        int half = (total / 2);

        int l = -1;
        int r = A.length;

        while (true) {
            int i = (l + r) / 2;
            int j = half - i - 2;

            Double Aleft = i >= 0 ? A[i] : Double.NEGATIVE_INFINITY;
            Double Aright = i + 1 < A.length ? A[i + 1] : Double.POSITIVE_INFINITY;
            Double Bleft = j >= 0 ? B[j] : Double.NEGATIVE_INFINITY;
            Double Bright = j + 1 < B.length ? B[j + 1] : Double.POSITIVE_INFINITY;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
                }
            } else if (Bleft > Aright) {
                l = i + 1;
            } else if (Aleft > Bright) {
                r = i - 1;
            }
        }
    }
}