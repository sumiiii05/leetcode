class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        Arrays.sort(nums);
        int size=1;
        int maxlen=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            int cur=nums[i];
            if(nums[i-1]==cur-1){
                size++;
            }
            else if(nums[i-1]==cur){
                maxlen=Math.max(maxlen,size);
                continue;
            }
            else{
                size=1;
            }
            maxlen=Math.max(maxlen,size);
        }
        return maxlen;
    }
}