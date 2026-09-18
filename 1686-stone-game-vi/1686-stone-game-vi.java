class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) ->
            (bobValues[b] + aliceValues[b])
            - (bobValues[a] + aliceValues[a])
        );
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            if (i % 2 == 0) {
                alice += aliceValues[index];
            } else {
                bob += bobValues[index];
            }
        }
        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        } else {
            return 0;
        }
    }
}