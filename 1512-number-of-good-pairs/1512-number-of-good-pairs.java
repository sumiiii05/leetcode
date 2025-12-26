class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int pairs=0;
        for(int i=0;i<nums.length;i++){
            int count=map.getOrDefault(nums[i],0);
            pairs+=count;
            int cc=count+1;
            map.put(nums[i],cc);
        }
        return pairs;
    }
}