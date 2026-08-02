class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int num : arr1) {
            freq[num]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
            while (freq[num] > 0) {
                ans[index++] = num;
                freq[num]--;
            }
        }
        for (int i = 0; i <= 1000; i++) {
            while (freq[i] > 0) {
                ans[index++] = i;
                freq[i]--;
            }
        }
        return ans;
    }
}