class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n= costs.length;
        int i=0,j=n-1;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long total=0;

        while(k>0){
            while(left.size()<candidates && i<=j){
                left.offer(costs[i++]);
            }
            while(right.size()<candidates && j>=i){
                right.offer(costs[j--]);
            }
            if(right.isEmpty() || (!left.isEmpty() && left.peek()<=right.peek())){
                total+=left.poll();
            }else{
                total+=right.poll();
            }
            k--;
        }
        return total;
    }
}