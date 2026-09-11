class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            for (int i = 0; i < k; i++) {
                int current = num + i;
                if (map.getOrDefault(current, 0) == 0) {
                    return false;
                }
                map.put(current, map.get(current) - 1);
            }
        }
        return true;
    }
}