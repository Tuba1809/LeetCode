class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            // Maintain increasing deque
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            // Maintain decreasing deque
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            // Window is invalid
            while (nums[maxDeque.peekFirst()]
                   - nums[minDeque.peekFirst()] > limit) {

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}