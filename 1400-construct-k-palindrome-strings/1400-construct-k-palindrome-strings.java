class Solution {
    public boolean canConstruct(String s, int k) {

        // Not enough characters to create k non-empty strings
        if (s.length() < k) {
            return false;
        }

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;

        // Count characters having odd frequency
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
