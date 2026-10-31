import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);

            if (count == ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(count).add(num);

            freq.put(num, count + 1);
        }

        return ans;
    }
}
