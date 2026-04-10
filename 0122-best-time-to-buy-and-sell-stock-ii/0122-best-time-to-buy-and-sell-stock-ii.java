class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,buy=Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++){
		    if(prices[i]<buy){
		        buy=prices[i];
		    }
		    else{
		        profit+=prices[i]-buy;
		        buy=prices[i];
		    }
		}
		return profit;
    }
}