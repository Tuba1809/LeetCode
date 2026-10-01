class Solution {
    public long minCost(int[] arr, int[] brr, long k) {

        int n = arr.length;

        // Option 1: Don't rearrange
        long cost1 = 0;

        for (int i = 0; i < n; i++) {
            cost1 += Math.abs((long) arr[i] - brr[i]);
        }

        // Sort copies for Option 2
        int[] sortedArr = arr.clone();
        int[] sortedBrr = brr.clone();

        Arrays.sort(sortedArr);
        Arrays.sort(sortedBrr);

        // Option 2: Rearrange + modify
        long cost2 = k;

        for (int i = 0; i < n; i++) {
            cost2 += Math.abs((long) sortedArr[i] - sortedBrr[i]);
        }

        return Math.min(cost1, cost2);
    }
}