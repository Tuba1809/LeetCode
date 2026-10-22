import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long x : freq.keySet()) {
            if (x == 1) {
                int count = freq.get(x);
                ans = Math.max(ans, count % 2 == 0 ? count - 1 : count);
                continue;
            }

            long curr = x;
            int len = 1;

            while (freq.getOrDefault(curr, 0) >= 2) {
                long next = curr * curr;

                if (freq.getOrDefault(next, 0) == 0) {
                    break;
                }

                len += 2;
                curr = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}




