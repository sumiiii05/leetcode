class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> freqmap= new HashMap<>();
        int pairs=0;
        for(int[] row:grid){
            freqmap.merge(Arrays.toString(row),1,Integer::sum);
        }
        for(int i=0;i<grid[0].length;i++){
            int col[]=new int[grid.length];
            for(int j=0;j<grid.length;j++){
                col[j]=grid[j][i];
            }
            pairs += freqmap.getOrDefault(Arrays.toString(col),0);
        }
        return pairs;
    }
}