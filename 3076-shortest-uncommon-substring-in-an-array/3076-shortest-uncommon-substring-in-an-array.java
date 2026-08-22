class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String current = arr[i];
            String best = "";
            for (int len = 1; len <= current.length(); len++) {
                String candidate = null;
                for (int start = 0; start + len <= current.length(); start++) {
                    String sub = current.substring(start, start + len);
                    boolean unique = true;
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (arr[j].contains(sub)) {
                            unique = false;
                            break;
                        }
                    }
                    if (unique) {
                        if (candidate == null ||
                            sub.compareTo(candidate) < 0) {
                            candidate = sub;
                        }
                    }
                }
                if (candidate != null) {
                    best = candidate;
                    break;
                }
            }
            answer[i] = best;
        }
        return answer;
    }
}