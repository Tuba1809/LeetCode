class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (skills[i] > skills[maxIndex]) {
                maxIndex = i;
            }
        }
        if (k >= n - 1) {
            return maxIndex;
        }
        int currentWinner = 0;
        int wins = 0;
        for (int i = 1; i < n; i++) {
            if (skills[currentWinner] > skills[i]) {
                wins++;
            } else {
                currentWinner = i;
                wins = 1;
            }
            if (wins == k) {
                return currentWinner;
            }
        }
        return currentWinner;
    }
}