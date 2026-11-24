class Solution {
    public int maxDistance(String s, int k) {

        int north = 0, south = 0;
        int east = 0, west = 0;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'N') north++;
            else if (ch == 'S') south++;
            else if (ch == 'E') east++;
            else west++;

            // Original Manhattan distance
            int distance = Math.abs(north - south)
                         + Math.abs(east - west);

            // Maximum possible distance after k changes
            int possible = Math.min(i + 1, distance + 2 * k);

            ans = Math.max(ans, possible);
        }

        return ans;
    }
}
