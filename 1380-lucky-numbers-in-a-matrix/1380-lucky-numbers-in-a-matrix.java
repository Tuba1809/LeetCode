import java.util.*;
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int m = matrix[i][0];
            int j = 0;
            for (int k = 1; k < matrix[i].length; k++) {
                if (matrix[i][k] < m) {
                    m = matrix[i][k];
                    j = k;
                }
            }
            int ma = matrix[0][j];
            for (int k = 1; k < matrix.length; k++) {
                ma = Math.max(ma, matrix[k][j]);
            }
            if (ma == m) {
                res.add(m);
            }
        }
        return res;
    }
}