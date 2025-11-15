class Solution { //11/15/2025
    int[][] dist;
    int [][] matrix;
    int rows;
    int cols;
    int max;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        this.matrix = matrix;
        cols = matrix[0].length;
        dist = new int[rows][cols];
        max = 0;
        for ( int row = 0; row < rows; row++){
            for ( int col = 0; col < cols; col++){
                max = Math.max(max,dfs(row,col));
            }
        }
        return max;
        
    }

    public int dfs( int row, int col){
        if ( dist[row][col] != 0) return dist[row][col];
        dist[row][col] = 1;
        int l = dfsHelper(row,col-1, matrix[row][col]);
        int r = dfsHelper(row,col+1, matrix[row][col]);
        int u = dfsHelper(row-1,col, matrix[row][col]);
        int d = dfsHelper(row+1,col, matrix[row][col]);
        dist[row][col] += Math.max(l, Math.max(r, Math.max(u,d)));
        return dist[row][col];
    }

    public int dfsHelper( int row, int col, int prev){
        if ( row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] <= prev) return 0;
        return dfs(row,col);
    }
}

/**
dist[][] = new arr of matrix all 0s
rows 
cols
matrix
max = 0

loop through mxn
    max = max(max,dfs( row, col))
return max;

int dfs(row, col)
    if dist[row][col] != 0 return that value
    dist[row][col] = 1;
        l = dfsHelper(row+1,col, dist[row][col])
        r = dfsHelper(row-1,col, dist[row][col])
        ...
    dist[row][co] += max(..)

dfsHelper(row,col, prev)
    if row,col inbounds and matrix[row][col] > prev
        return dfs(row,col)


 */
