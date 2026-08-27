class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][] sum = new int[m][n];
        int[][] count = new int[m][n];
        for (int r = 0; r <= m - 3; r++) {
            for (int c = 0; c <= n - 3; c++) {
                boolean valid = true;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (i < r + 2 &&
                            Math.abs(image[i][j] - image[i + 1][j]) > threshold) {
                            valid = false;
                        }
                        if (j < c + 2 &&
                            Math.abs(image[i][j] - image[i][j + 1]) > threshold) {
                            valid = false;
                        }
                    }
                }
                if (!valid) {
                    continue;
                }
                int regionSum = 0;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        regionSum += image[i][j];
                    }
                }
                int average = regionSum / 9;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        sum[i][j] += average;
                        count[i][j]++;
                    }
                }
            }
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0) {
                    result[i][j] = image[i][j];
                } else {
                    result[i][j] = sum[i][j] / count[i][j];
                }
            }
        }
        return result;
    }
}