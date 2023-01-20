class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        int group;
        HashSet<String> hs = new HashSet<>();
        for (int row = 0; row < n; row++){
            for ( int col = 0; col < n; col++){
                if (board[row][col] != '.'){
                    //System.out.println("row" + row + "" + board[row][col]);
                    if( !hs.add("row" + row + "" + board[row][col]) ) { return false; }
                    //System.out.println("col" + col + "" + board[row][col]);
                    if ( ! hs.add("col" + col + "" + board[row][col]) ) { return false;}
                    group = (((row/3) * 3) + ((col/3)+1));
                    // System.out.println("group" + group +  board[row][col]);
                    if ( !hs.add("group" + group +  board[row][col]) ) { return false;}
                }
                
            }
        }          
        return true;
    }
}
