class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] solutions = new int[coins.length][amount+1];
        int steps = coinRec(coins, amount, 0, solutions);
        if (steps >= 100001){return -1;}
        return steps;
        
    }

    public int coinRec(int[] coins, int amount, int pos, int[][] solutions){
        if (amount == 0){return 0;}
        if (amount <0 || pos >= coins.length){return 100001;}
        if (solutions[pos][amount] == 0){
            // System.out.println( "pos:" + pos + " amt:" + amount);
            int takeMove = 1+ coinRec(coins, amount - coins[pos], pos + 1, solutions);
            int takeStay = 1+ coinRec(coins, amount - coins[pos], pos, solutions);
            int skip = coinRec(coins, amount, pos+1, solutions);

            return solutions[pos][amount] = Math.min(skip, Math.min(takeMove,takeStay));
        } else {return solutions[pos][amount];}

    }

}

//look at the first coin, decide whether to take or pass
// when you take you also decide whther to stay or move on.
/*

int coinChange( coins, amount, pos){
    if( amount = 0) {return 0;}
    if( ammount < 0) { return Integer.MAx)
    if( pos = coins.length) {return Integer.Max}
    
    takeMove = 1 + (coins, amount -coins[pos], pos++);
    takeStay = 1 + (coins, amount -coins[pos], pos);
    skip = 1 + (coins, amount, pos++);

    return Min(takeMove,takeStay,skip);
}
*/
