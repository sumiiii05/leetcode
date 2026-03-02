class Solution {
    public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    List<List<String>> board = new ArrayList<>();
    for(int i= 0 ; i < n; i++)
    {
    List<String> ds = new ArrayList<>(); 
    for(int j =0; j< n; j++)
    {
        ds.add(".");
    } 
    board.add(ds);
    }
    int[] left = new int[n];
    int[] ld = new int[2 * n -1];
    int[] ud = new int[2*n - 1];
    validBoard(0,ans, board, n,ld, left, ud);
    return ans;
    }
    public void  validBoard(int col, List<List<String>> ans,List<List<String>> board, int n, int[] ld, int[] left, int[] ud){
        if(col == n){List<String> temp = new ArrayList<>();
            for( int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    sb.append(board.get(i).get(j));
                } 
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }
        for(int row =0; row< n; row++){
            if(left[row] == 0 && ud[(n-1) + (col-row)] == 0 && ld[col + row] == 0){
                board.get(row).set(col, "Q");
                left[row] = 1; ud[(n-1) + (col-row)] =1; ld[col + row] =1;
                validBoard(col +1,ans, board, n, ld, left, ud);
                board.get(row).set(col, ".");
                left[row] = 0; ud[(n-1) + (col-row)] =0; ld[col + row] =0;

            }
        }
    }
}