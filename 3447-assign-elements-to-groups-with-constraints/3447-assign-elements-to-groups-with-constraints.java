class Solution {
    public int[] assignElements(int[] groups, int[] elements) {

        int n = groups.length;

        // Find maximum group size
        int max = 0;

        for (int num : groups) {
            max = Math.max(max, num);
        }

        // Store smallest valid element index
        int[] firstIndex = new int[max + 1];
        Arrays.fill(firstIndex, -1);

        // Avoid processing duplicate elements
        boolean[] processed = new boolean[max + 1];

        for (int j = 0; j < elements.length; j++) {

            int x = elements[j];

            // Ignore values larger than max and duplicates
            if (x > max || processed[x]) {
                continue;
            }

            processed[x] = true;

            // Visit all multiples of x
            for (int multiple = x; multiple <= max; multiple += x) {

                if (firstIndex[multiple] == -1) {
                    firstIndex[multiple] = j;
                }
            }
        }

        // Build answer
        int[] assigned = new int[n];

        for (int i = 0; i < n; i++) {
            assigned[i] = firstIndex[groups[i]];
        }

        return assigned;
    }
}


