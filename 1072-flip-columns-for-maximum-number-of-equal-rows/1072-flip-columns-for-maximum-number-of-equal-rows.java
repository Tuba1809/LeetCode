class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {

            StringBuilder pattern = new StringBuilder();

            int first = matrix[i][0];

            for (int j = 0; j < matrix[0].length; j++) {

                // Make the first element of every pattern 0
                pattern.append(matrix[i][j] ^ first);
            }

            String key = pattern.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0;

        for (int count : map.values()) {
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
