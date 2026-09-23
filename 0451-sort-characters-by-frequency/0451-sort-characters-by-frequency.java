class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder answer = new StringBuilder();
        for (char c : chars) {
            int frequency = map.get(c);
            for (int i = 0; i < frequency; i++) {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}