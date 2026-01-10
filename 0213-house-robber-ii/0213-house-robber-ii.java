class Solution {
    static int optimal(int nums[],int dp[]){
            dp[0]=nums[0];
            dp[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<dp.length;i++){
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            return dp[dp.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int n=nums.length;
        int nums1[]=new int[n-1];
        int nums2[]=new int[n-1];
        int dp1[]=new int[n-1];
        int dp2[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            nums1[i]=nums[i];
        }
        int idx=0;
        for(int i=1;i<n;i++){
            nums2[idx++]=nums[i];
        }
        int res1=optimal(nums1,dp1);
        int res2=optimal(nums2,dp2);
        return Math.max(res1,res2);
    }
}