class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];

        // Count frequency of each character in s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // Add characters according to order
        for (char ch : order.toCharArray()) {
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }

        // Add remaining characters
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return ans.toString();
    }
}
