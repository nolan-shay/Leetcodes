class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for ( int row = 0; row < matrix.length; row++){
            for ( int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == 0){
                    rowSet.add(row);
                    colSet.add(col);
                }
            }
        }

        for ( int row = 0; row < matrix.length; row++){
            for ( int col = 0; col < matrix[0].length; col++){
                if (rowSet.contains(row) || colSet.contains(col)){
                    matrix[row][col] =
                }
            }
        }
        
        
    }
}

/**
rowSet = {}
columnSet = {}

for row = 0 
    for col= 0
        if matrix[row][col] == 0
            rowSet.add(row)
            colSet.add(col)

for row = 0 
    for col= 0
        if rowSet.contains(row) or colSet.conatins(col)
            set it to 0;

 */
