class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // Number has already appeared
                ans.add(Math.abs(nums[i]));
            } else {
                // Mark this number as visited
                nums[index] = -nums[index];
            }
        }

        return ans;
    }
}
