class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {

        int n = s.length();

        // Each substring must have equal length
        int len = n / k;

        Map<String, Integer> map = new HashMap<>();

        // Divide s into k substrings and count them
        for (int i = 0; i < n; i += len) {
            String sub = s.substring(i, i + len);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        // Divide t into k substrings and compare
        for (int i = 0; i < n; i += len) {
            String sub = t.substring(i, i + len);

            if (!map.containsKey(sub)) {
                return false;
            }

            map.put(sub, map.get(sub) - 1);

            if (map.get(sub) == 0) {
                map.remove(sub);
            }
        }

        return map.isEmpty();
    }
}
