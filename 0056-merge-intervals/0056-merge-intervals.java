class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        List<int[]> merged=new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=0;i<intervals.length;i++){
            int last[]=merged.get(merged.size()-1);
            int curstart=intervals[i][0];
            int curend=intervals[i][1];
            if(curstart<=last[1]){
                last[1]=Math.max(last[1],intervals[i][1]);
            }
            else{
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}