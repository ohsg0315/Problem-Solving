class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int idx = m + n - 1, first = m - 1, second = n - 1; idx >= 0 && second >= 0; idx--) {
            nums1[idx] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
        }
    }
}