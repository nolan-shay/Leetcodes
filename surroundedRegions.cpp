class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int rows = board.size();
        int cols = board[0].size();
        for ( int row = 0; row < rows; ++row ){
            dfs(board, row, 0);
            dfs(board, row, cols-1);
        }
        for ( int col = 0; col < cols; ++col ){
            dfs(board,0,col);
            dfs(board, rows-1, col);
        }

        for ( int x = 0; x< rows; ++x){
            for ( int y = 0; y< cols; ++y){
                if (board[x][y] == 'V'){
                    board[x][y] = 'O';
                } else {
                    board[x][y] = 'X';
                }
            }
        }
    }

    void dfs(vector<vector<char>>& board, int x, int y){
        if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size() ) return;
        if (board[x][y] != 'O') return;
        else board[x][y] = 'V';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }
};

/*
make a dfs function that sets all 0's to V's
call dfs from the edge nodes
iterate through the whole array and set 0's to X and V's to 0s
*/
