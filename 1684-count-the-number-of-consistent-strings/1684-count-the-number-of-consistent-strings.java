class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        char[] a= allowed.toCharArray();
        for (String s: words){
            count++;
            for (int i=0; i<s.length(); i++){
                if (allowed.indexOf(s.charAt(i))==-1){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}