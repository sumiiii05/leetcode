class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        return subarrayWithSumAtMostK(nums, k)
             - subarrayWithSumAtMostK(nums, k - 1);
    }

    private int subarrayWithSumAtMostK(int[] nums, int k) {
        if (k < 0) return 0;

        int l = 0;
        int sum = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
}