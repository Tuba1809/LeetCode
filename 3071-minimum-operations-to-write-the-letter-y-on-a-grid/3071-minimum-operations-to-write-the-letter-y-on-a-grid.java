class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int mid = n / 2;
        int[] yCount = new int[3];
        int[] nonYCount = new int[3];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean isY =
                    (r == c && r <= mid) ||
                    (r + c == n - 1 && r <= mid) ||
                    (c == mid && r >= mid);
                if (isY) {
                    yCount[grid[r][c]]++;
                } else {
                    nonYCount[grid[r][c]]++;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int y = 0; y < 3; y++) {
            for (int nonY = 0; nonY < 3; nonY++) {
                if (y == nonY) {
                    continue;
                }
                int operations =
                    (yCount[0] + yCount[1] + yCount[2] - yCount[y])
                    +
                    (nonYCount[0] + nonYCount[1] + nonYCount[2] - nonYCount[nonY]);
                answer = Math.min(answer, operations);
            }
        }
        return answer;
    }
}