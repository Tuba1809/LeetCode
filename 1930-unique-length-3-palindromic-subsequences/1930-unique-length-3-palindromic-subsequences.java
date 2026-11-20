class Solution {
    public int countPalindromicSubsequence(String s) {

        int ans = 0;

        // Check all possible outer characters
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            // At least one character must exist between them
            if (first != -1 && last - first >= 2) {

                HashSet<Character> set = new HashSet<>();

                // Find distinct middle characters
                for (int i = first + 1; i < last; i++) {
                    set.add(s.charAt(i));
                }

                ans += set.size();
            }
        }

        return ans;
    }
}
