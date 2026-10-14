import java.util.*;

class Solution {
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        long total = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            total += num;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = Integer.MIN_VALUE;

        for (int x : nums) {
            long remaining = total - x;

            if (remaining % 2 != 0) {
                continue;
            }

            long sum = remaining / 2;

            if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
                continue;
            }

            int s = (int) sum;

            if (freq.containsKey(s)) {
                if (s != x || freq.get(s) > 1) {
                    ans = Math.max(ans, x);
                }
            }
        }

        return ans;
    }
}
