class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int len = 1;
        for (int i = 1; i < n + k - 1; i++) {
            if (colors[i % n] != colors[(i - 1) % n]) {
                len++;
            } else {
                len = 1;
            }
            if (len >= k && i - k + 1 < n) {
                count++;
            }
        }
        return count;
    }
}