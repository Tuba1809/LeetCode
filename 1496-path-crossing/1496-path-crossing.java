class Solution {
    public boolean isPathCrossing(String path) {
        ArrayList<String> visit = new ArrayList<>();
        int x = 0;
        int y = 0;
        visit.add("0,0");
        for (char ch : path.toCharArray()) {
            if (ch == 'N') y++;
            else if (ch == 'S') y--;
            else if (ch == 'E') x++;
            else x--;
            String pos = x + "," + y;
            if (visit.contains(pos)) {
                return true;
            }
            visit.add(pos);
        }
        return false;
    }
}