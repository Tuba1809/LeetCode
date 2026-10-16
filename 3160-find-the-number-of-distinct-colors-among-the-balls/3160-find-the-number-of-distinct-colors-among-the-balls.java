import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        HashMap<Integer, Integer> ballColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball already has a color
            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);

                // Decrease the count of its old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);

                // Remove the color if no balls have it
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            // Assign the new color to the ball
            ballColor.put(ball, color);

            // Increase the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            // Number of distinct colors currently present
            result[i] = colorCount.size();
        }

        return result;
    }
}
