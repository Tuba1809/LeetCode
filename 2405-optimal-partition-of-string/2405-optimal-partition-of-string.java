class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];

        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (seen[ch - 'a']) {
                count++;
                seen = new boolean[26];
            }

            seen[ch - 'a'] = true;
        }

        return count;
    }
}
