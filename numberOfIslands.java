class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for ( int row = 0; row < grid.length; row++){
            for ( int col = 0; col < grid[0].length; col++){
                if ( grid[row][col] == '1'){
                    numIslands++;
                    islandDFS(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    private void islandDFS(char[][] grid, int row, int col){
        if (!( row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1')) return;
        grid[row][col] = '0';
        islandDFS(grid, row, col-1);
        islandDFS(grid, row, col+1);
        islandDFS(grid, row-1, col);
        islandDFS(grid, row+1, col);

    }
}
