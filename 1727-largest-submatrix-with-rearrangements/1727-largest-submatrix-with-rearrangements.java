class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];

        // Calculate consecutive 1s in each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {

                if (matrix[i][j] == 1) {
                    if (i == 0) {
                        height[i][j] = 1;
                    } else {
                        height[i][j] = height[i - 1][j] + 1;
                    }
                }
            }
        }

        int answer = 0;

        // For every row
        for (int i = 0; i < m; i++) {

            // Sort heights in descending order
            Arrays.sort(height[i]);

            // Calculate maximum area
            for (int j = n - 1; j >= 0; j--) {

                int width = n - j;
                int h = height[i][j];

                answer = Math.max(answer, h * width);
            }
        }

        return answer;
    }
}