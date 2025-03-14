class Solution {
   public int maxProfit(int[] prices) {
       int n = prices.length;
       int[][][] dpArr = new int [n+2][n][2];
       for ( int col = 0; col < n; col++){
           dpArr[n+1][col][1] = 0;
           dpArr[n][col][1] = 0;
       }
       dpArr[n+1][0][0] = 0;
       dpArr[n][0][0] = 0;

       for ( int row = n-1; row >0; row --){
           for (int col = row-1; col >= 0; col--){
               dpArr[row][col][1] = Math.max(
                   (prices[row] - prices[col]) + dpArr[row+2][0][0],
                   dpArr[row+1][col][1]
               );
           }
           dpArr[row][0][0] = Math.max(
               dpArr[row+1][row][1],
               dpArr[row+1][0][0]
           );
       }
       return Math.max(
           dpArr[1][0][1],
           dpArr[1][0][0]
       );
   }
}
/**
    public int maxProfit(int[] prices) {
        return helper(prices,0,0,false);
    }

    public int helper( int[] prices, int pos, int bought, boolean owned){
        if (pos >= prices.length) return 0;
        int action;
        int wait;
        if (owned) {
            action = (prices[pos] - prices[bought]) + helper(prices,pos+2,0,false);
        } else {
            action = helper(prices, pos+1, pos, true);
        }
        wait = helper(prices,pos+1,bought,owned);
        return Math.max(action,wait);
    }
 */


/**
helper(prices, 0, 0, false)


at each stock price we have 3 options

helper( pos, bought, owned)
buy = helper(prices[], pos+1, pos, true) 
sell = price[pos] - price[bought] helper(prices[], pos+2, pos?, false);
wait = price[pos+1,bought,owned]

helper(1,0, true)
    sell = prices[1] -prices[0] + helper(3,0,false)
    wait = helper(2,0,true)

helper(1,0,false)
    buy = helper(2,1,true)
    wait = helper(2,0,true)


 */
