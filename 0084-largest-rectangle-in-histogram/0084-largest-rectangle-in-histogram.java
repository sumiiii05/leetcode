class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=heights.length;i++){
            int currheight=(i==heights.length) ? 0:heights[i];
            while(!st.isEmpty() && currheight<heights[st.peek()]){
                int height=heights[st.pop()];
                int right=i;
                int left=st.isEmpty() ? -1:st.peek();
                int width=right-left-1;
                maxarea=Math.max(maxarea,height*width);
            }
            st.push(i);
        }
        return maxarea;
    }
}