class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int x = nums2[0] - nums1[i];
            int p1 = 0;
            int p2 = 0;
            int removed = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] + x == nums2[p2]) {
                    p1++;
                    p2++;
                } else {
                    removed++;
                    p1++;
                }
            }
            removed += nums1.length - p1;
            if (removed == 2) {
                ans = Math.min(ans, x);
            }
        }
        return ans;
    }
}