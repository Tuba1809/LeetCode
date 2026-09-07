class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long topSum = 0;
        long bottomSum = 0;
        for (int j = 0; j < n; j++) {
            topSum += grid[0][j];
        }
        long answer = Long.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            topSum -= grid[0][j];
            long secondRobot = Math.max(topSum, bottomSum);
            answer = Math.min(answer, secondRobot);
            bottomSum += grid[1][j];
        }
        return answer;
    }
}