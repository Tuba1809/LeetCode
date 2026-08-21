class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int total = 0;
        for (int x : possible) {
            if (x == 1) {
                total += 1;
            } else {
                total -= 1;
            }
        }
        int alice = 0;
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 1) {
                alice += 1;
            } else {
                alice -= 1;
            }
            int bob = total - alice;
            if (alice > bob) {
                return i + 1;
            }
        }
        return -1;
    }
}