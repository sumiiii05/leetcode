class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for(int i = 0;i<n;i++) idx[i] = i;
        
        Arrays.sort(idx,(a,b) -> nums2[b] - nums2[a]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long sum = 0;
        
        long max_res = 0;
        for(int ind = 0;ind< n;ind++){
            int i = idx[ind];
            pq.add(nums1[i]);sum += nums1[i];
            if(pq.size() > k) sum -=  pq.poll();
            if(pq.size() == k) max_res = Math.max(max_res,sum * (long) nums2[i]);
        }
        
        return max_res;
    }
}