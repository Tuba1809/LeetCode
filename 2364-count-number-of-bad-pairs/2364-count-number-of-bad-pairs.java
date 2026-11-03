import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        long bad = 0;

        for (int j = 0; j < nums.length; j++) {
            int key = nums[j] - j;

            bad += j - map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return bad;
    }
}
