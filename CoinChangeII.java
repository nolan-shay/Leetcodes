class Solution {  //11/10/25
    public int change(int amount, int[] coins) {
        int[][] dpArr = new int[coins.length+1][amount+1];
        int cols = amount +1;
        int rows = coins.length+1;
        for (int c = 0; c < cols; c++) dpArr[rows-1][c] = 0;
        for (int i = 0 ; i < rows; i++) dpArr[i][0] = 1;

        
        for ( int row = rows-2; row >= 0; row--){
            for ( int amt = 0; amt < cols; amt++){
                dpArr[row][amt] = dpArr[row+1][amt];
                int nextAmount = amt - coins[row];
                if ( nextAmount >= 0) dpArr[row][amt] += dpArr[row][nextAmount];
            }
        }

        return dpArr[0][amount];
    }
}
