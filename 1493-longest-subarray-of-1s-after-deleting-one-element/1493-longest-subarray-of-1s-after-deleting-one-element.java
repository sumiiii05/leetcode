class Solution {
    public int longestSubarray(int[] nums) {
       int l=0,zeroes=0,maxCount=0;
       for(int r=0;r<nums.length;r++){
        if(nums[r]==0)
            zeroes++;
        while(zeroes>1){
            if(nums[l]==0)
                zeroes--;
            l++;
        }
        maxCount=Math.max(maxCount,r-l);
       } 
       return maxCount;
    }
}