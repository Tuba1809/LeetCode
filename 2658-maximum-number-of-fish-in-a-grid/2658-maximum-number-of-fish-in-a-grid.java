class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int fish = dfs(grid, i, j);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }
        return maxFish;
    }
    private int dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }
        if (grid[r][c] == 0) {
            return 0;
        }
        int fish = grid[r][c];
        grid[r][c] = 0;
        fish += dfs(grid, r + 1, c);
        fish += dfs(grid, r - 1, c);
        fish += dfs(grid, r, c + 1);
        fish += dfs(grid, r, c - 1);
        return fish;
    }
}