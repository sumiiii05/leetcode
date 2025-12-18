class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();

        while(left<right){
            int mid=left+(right-left)/2;
            if(canFinish(piles,h,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles,int h,int speed){
        int totalhrs=0;
        for(int pile:piles){
            totalhrs += (pile+speed-1)/speed;
        }
        return totalhrs<=h;
    }
}