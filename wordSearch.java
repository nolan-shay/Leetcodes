class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for ( int row = 0; row < board.length; row++){
            for ( int col = 0; col < board[0].length; col++)
                if ( board[row][col] == word.charAt(0)){
                    HashSet<List<Integer>> visited = new HashSet<>();
                    visited.add( Arrays.asList(row,col) );
                    if ( existHelper( row, col, board, word.substring(1,word.length()), visited) ) return true;
                }
        }
        return false;
    }

    public boolean existHelper( int row, int col, char[][] board, String word, HashSet<List<Integer>> visited){
        if ( word.length() == 0) return true;
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;

        int[] downPos = {row+1, col};
        int[] upPos = {row-1, col};
        int[] leftPos = {row, col-1};
        int[] rightPos = {row, col+1};

        if ( row +1 < board.length && !visited.contains(Arrays.asList(row+1,col)) && board[row+1][col] == word.charAt(0)){
            visited.add(Arrays.asList(row+1,col));
            down = existHelper( row+1, col, board, word.substring(1,word.length()), visited);
            visited.remove(Arrays.asList(row+1,col));
        }
        if ( row - 1 >= 0 && !visited.contains(Arrays.asList(row-1,col)) && board[row-1][col] == word.charAt(0)){
            visited.add(Arrays.asList(row-1,col));
            up = existHelper( row-1, col, board, word.substring(1,word.length()), visited);
            visited.remove(Arrays.asList(row-1,col));
        }
        if ( col +1 < board[0].length && !visited.contains(Arrays.asList(row,col+1)) && board[row][col+1] == word.charAt(0)){
            visited.add(Arrays.asList(row,col+1));
            right = existHelper( row, col+1, board, word.substring(1,word.length()), visited);
            visited.remove(Arrays.asList(row,col+1));
        }
        if ( col-1 >= 0 && !visited.contains(Arrays.asList(row,col-1)) && board[row][col-1] == word.charAt(0)){
            visited.add(Arrays.asList(row,col-1));
            left = existHelper( row, col-1, board, word.substring(1,word.length()), visited);
            visited.remove(Arrays.asList(row,col-1));
        }
        
        return ( left || right || down || up);

    }
}
