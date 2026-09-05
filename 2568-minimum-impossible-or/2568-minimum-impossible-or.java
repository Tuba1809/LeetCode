class Solution {
    public int minImpossibleOR(int[] nums) {
        boolean[] present = new boolean[31];
        for (int num : nums) {
            if ((num & (num - 1)) == 0) {
                int power = 0;
                while (num > 1) {
                    num >>= 1;
                    power++;
                }
                present[power] = true;
            }
        }
        for (int i = 0; i < 31; i++) {
            if (!present[i]) {
                return 1 << i;
            }
        }
        return -1;
    }
}