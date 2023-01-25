class Solution {
    public int uniquePaths(int m, int n) {
        int[][] moves = new int[m][n];
        moves[m-1][n-1] = 1;
        int move;
        for (int row = m-1; row >= 0; row--){
            for (int col = n-1; col >= 0; col--){
                if ( row != m-1) moves[row][col] += moves[row+1][col];
                if ( col != n-1) moves[row][col] += moves[row][col+1];
            }
        }
        return moves[0][0];
        
    }
}


    // if (m == 1 && n == 1) { return 1;}
    // int down = 0;
    // int right = 0;
    // if (n > 1) down = uniquePaths(m, n-1);
    // if (m > 1) right = uniquePaths(m-1, n);
    // return down + right;
