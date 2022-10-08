class Solution {
    public int maxProfit(int[] prices) {
        //base cases length 1 return 0;
        if  (prices.length == 1) { return 0;}
        // else
        int[] ans = new int[prices.length];
        ans[prices.length -1] = 0;
        int max = 0;
        int dif;
        
        for (int i = prices.length -2; i >=0; i--){
            dif = prices[i+1] - prices[i] + ans[i+1];
            if (dif > 0 ) { ans[i] = dif;}
            else { ans[i] = 0;}
            if (dif > max){ max = dif;}
        }
        
        
        return max;
    }
}
