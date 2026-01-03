class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
       Deque<Integer> deq=new LinkedList<>();
       int res[]=new int[n-k+1];
       int idx=0;
       for(int i=0;i<n;i++){
            while(!deq.isEmpty() && deq.peekFirst()<=i-k){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && nums[deq.peekLast()]<nums[i]){
                deq.pollLast();
            }
            deq.offerLast(i);
            if(i>=k-1){
                res[idx++]=nums[deq.peekFirst()];
            }
       }
       return res; 
    }
}