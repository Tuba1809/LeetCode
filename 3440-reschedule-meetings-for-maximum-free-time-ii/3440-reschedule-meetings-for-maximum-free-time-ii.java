class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

        int n = startTime.length;

        // Calculate free gaps
        int[] gaps = new int[n + 1];

        gaps[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        gaps[n] = eventTime - endTime[n - 1];

        // Prefix maximum of gaps
        int[] prefixMax = new int[n + 1];
        prefixMax[0] = gaps[0];

        for (int i = 1; i <= n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], gaps[i]);
        }

        // Suffix maximum of gaps
        int[] suffixMax = new int[n + 1];
        suffixMax[n] = gaps[n];

        for (int i = n - 1; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], gaps[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            int duration = endTime[i] - startTime[i];

            // Removing meeting i merges the gaps
            // immediately before and after it.
            int mergedGap = gaps[i] + duration + gaps[i + 1];

            // Largest gap excluding gaps[i] and gaps[i + 1]
            int otherGap = 0;

            if (i - 1 >= 0) {
                otherGap = Math.max(otherGap, prefixMax[i - 1]);
            }

            if (i + 2 <= n) {
                otherGap = Math.max(otherGap, suffixMax[i + 2]);
            }

            if (otherGap >= duration) {
                // Meeting fits completely somewhere else
                answer = Math.max(answer, mergedGap);
            } else {
                // Meeting must occupy part of the merged gap
                answer = Math.max(answer, mergedGap - duration);
            }
        }

        return answer;
    }
}