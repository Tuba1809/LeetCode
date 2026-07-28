class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        int zeros = s.length() - ones;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ones - 1; i++) {
            ans.append('1');
        }
        for (int i = 0; i < zeros; i++) {
            ans.append('0');
        }
        ans.append('1');
        return ans.toString();
    }
} 