class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store frequencies in a list
        List<Integer> freq = new ArrayList<>(map.values());

        // Step 3: Sort frequencies in ascending order
        Collections.sort(freq);

        // Step 4: Remove numbers with smallest frequencies
        int unique = freq.size();

        for (int count : freq) {
            if (k >= count) {
                k -= count;
                unique--;
            } else {
                break;
            }
        }

        return unique;
    }
}
