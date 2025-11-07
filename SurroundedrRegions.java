class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for ( int r = 0; r < rows; r++){
            dfs(r,0,board);
            dfs(r,cols-1,board);
        }
        for ( int c = 0; c < cols; c++){
            dfs(0,c,board);
            dfs(rows-1,c,board);
        }

        for ( int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'V') board[r][c] = 'O';
            }
        }
    }

    public void dfs( int row, int col, char[][] board){
        if ( row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == 'X' || board[row][col] == 'V') return;
        board[row][col] = 'V';
        dfs(row-1,col,board);
        dfs(row+1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);
    }
}


/*

scan the edges.
    perform dfs on the zeroes
        set them to V

scan the whole array resettinng
    0 -> X
    V -> 0

*/
