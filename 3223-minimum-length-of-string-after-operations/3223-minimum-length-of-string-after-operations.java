class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int length = 0;

        for (int count : freq) {
            if (count == 0) {
                continue;
            }

            if (count % 2 == 0) {
                length += 2;
            } else {
                length += 1;
            }
        }

        return length;
    }
}
