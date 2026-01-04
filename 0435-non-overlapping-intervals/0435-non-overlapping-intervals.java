class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        int count=0;
        int prevend=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int curstart=intervals[i][0];
            int curend=intervals[i][1];
            if(curstart<prevend){
                count++;
            }
            else{
                prevend=curend;
            }
        }
        return count;
    }
}