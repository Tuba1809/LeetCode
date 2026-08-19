class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int lastLower = -1;
            int firstUpper = -1;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch == c) {
                    lastLower = i;
                }
                if (ch == Character.toUpperCase(c) && firstUpper == -1) {
                    firstUpper = i;
                }
            }
            if (lastLower != -1 &&
                firstUpper != -1 &&
                lastLower < firstUpper) {
                ans++;
            }
        }
        return ans;
    }
}