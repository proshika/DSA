class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        double median = 0.0;
        int[] ans = new int[n];
        for (int i = 0; i < n1; i++) {
            ans[i] = nums1[i];
        }
        for (int j = 0; j < n2; j++) {
            ans[n1+j] = nums2[j];
        }

        Arrays.sort(ans);

            if (n % 2 == 0) {
                median = (ans[n / 2 - 1] + ans[n / 2]) / 2.0;
            } else {
                median = ans[n / 2];
            }
        return median;
    }
}