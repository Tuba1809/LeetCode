class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        String max = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                max = s.replace(c, '9');
                break;
            }
        }
        char first = s.charAt(0);
        String min = s.replace(first, '0');
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}