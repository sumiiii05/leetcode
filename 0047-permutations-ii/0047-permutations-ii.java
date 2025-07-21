class Solution {
    public void recursivecall(List<List<Integer>> returnList, List<Integer> templist, boolean[] vis, int[] nums) {
        if(templist.size() == nums.length && !returnList.contains(templist)){
            returnList.add(new ArrayList<>(templist));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(vis[i]) continue;

            vis[i] = true;
            templist.add(nums[i]);
            recursivecall(returnList , templist , vis , nums);
            templist.remove(templist.size() - 1);
            vis[i] = false;
        }

        return;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int m = nums.length;
        boolean[] vis = new boolean[m];

        List<List<Integer>> returnList = new ArrayList<>();
        recursivecall(returnList, new ArrayList<>(), vis, nums);

        return returnList;
    }
}