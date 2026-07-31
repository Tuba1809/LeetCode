class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            String s = String.valueOf(nums[left]) + String.valueOf(nums[right]);
            sum += Long.parseLong(s);
            left++;
            right--;
        }
        if (left == right) {
            sum += nums[left];
        }
        return sum;
    }
}