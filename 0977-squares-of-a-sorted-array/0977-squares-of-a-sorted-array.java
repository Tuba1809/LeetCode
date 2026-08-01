import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList <Integer> res = new ArrayList<>();
        for (int i=0 ; i<nums.length ; i++){
            res.add(nums[i]*nums[i]);
        }
        Collections.sort(res);
        int[] ans = new int[res.size()];
        for(int i = 0; i<nums.length ; i++){
            ans[i]= res.get(i);
        }
        return ans;
    }
}