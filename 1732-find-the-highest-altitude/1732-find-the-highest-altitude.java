class Solution {
    public int largestAltitude(int[] gain) {
        int curr=0,maxAlt=0;
        for(int i:gain){
            curr+=i;
            maxAlt=Math.max(maxAlt,curr);
        }
        return maxAlt;
    }
}