import java.util.*;
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0];
        int sum=nums[0];
        for (int i=0; i<nums.length-1; i++){
            if(nums[i+1]>nums[i]){
                sum+=nums[i+1];
            }
            else{
                sum=nums[i+1];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}