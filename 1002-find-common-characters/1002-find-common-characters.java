class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        StringBuilder[] arr = new StringBuilder[words.length];
        for (int i = 0; i < words.length; i++) {
            arr[i] = new StringBuilder(words[i]);
        }
        for (char c : arr[0].toString().toCharArray()) {
            boolean found = true;
            for (int i = 1; i < arr.length; i++) {
                int index = arr[i].indexOf(String.valueOf(c));
                if (index == -1) {
                    found = false;
                    break;
                }
                arr[i].deleteCharAt(index);
            }
            if (found) {
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }
}