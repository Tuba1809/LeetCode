import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = 0;
            int temp = num;

            // Calculate sum of digits
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (map.containsKey(sum)) {
                ans = Math.max(ans, num + map.get(sum));
            }

            // Store the maximum number for this digit sum
            map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
        }

        return ans;
    }
}
