class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;

        int[][] count = new int[26][n + 1];

        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;

            for (int k = 1; k <= len; k++) {
                count[ch - 'a'][k] += len - k + 1;
            }

            i = j;
        }

        for (int c = 0; c < 26; c++) {
            for (int len = 1; len <= n; len++) {
                if (count[c][len] >= 3) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}

