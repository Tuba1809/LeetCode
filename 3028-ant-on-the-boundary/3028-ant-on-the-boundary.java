class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int count=0;
        int curr=0;
        for (int i=0 ; i<nums.length ; i++){
            curr=curr+nums[i];
            if (curr==0){
                count=count+1;
            }
        }
        return count;
    }
}