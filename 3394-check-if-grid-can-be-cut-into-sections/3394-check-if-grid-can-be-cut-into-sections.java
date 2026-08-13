import java.util.*;
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }
        return canSplitIntoThree(xIntervals) || canSplitIntoThree(yIntervals);
    }
    private boolean canSplitIntoThree(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 1;
        int maxEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s >= maxEnd) {
                count++;
                if (count == 3) {
                    return true;
                }
                maxEnd = e;
            } else {
                maxEnd = Math.max(maxEnd, e);
            }
        }
        return false;
    }
}