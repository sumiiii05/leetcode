class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currsum=0;
        int maxsum=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            int bal=gas[i]-cost[i];
            currsum+=bal;
            maxsum+=bal;
            if(currsum<0){
                currsum=0;
                start=i+1;
            }
        }
        return maxsum>=0 ? start:-1;
    }
}