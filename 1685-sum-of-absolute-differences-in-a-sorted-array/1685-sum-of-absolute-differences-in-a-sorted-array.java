class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;

        // Find sum of all elements
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int current = nums[i];

            // Number of elements on the left
            int leftCount = i;

            // Number of elements on the right
            int rightCount = n - i - 1;

            // Contribution from left
            int leftPart = current * leftCount - leftSum;

            // Sum of elements on the right
            int rightSum = totalSum - leftSum - current;

            // Contribution from right
            int rightPart = rightSum - current * rightCount;

            result[i] = leftPart + rightPart;

            // Add current element to left sum
            leftSum += current;
        }

        return result;
    }
}