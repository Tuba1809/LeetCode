class Solution {
    public String lastNonEmptyString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }
        StringBuilder ans = new StringBuilder();
        boolean[] taken = new boolean[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == maxFreq && !taken[index]) {
                ans.append(s.charAt(i));
                taken[index] = true;
            }
        }
        return ans.reverse().toString();
    }
}