class SolutionBetter {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if (matrix[row][col] == 0){
                    if (row == 0 || col == 0){
                        if ( row == 0){
                            firstRowZero = true;
                            matrix[0][col] = 0;
                        } 
                        if ( col == 0){
                            firstColZero = true;
                            matrix[row][0] = 0;
                        }
                    } else {
                        matrix[row][0] = 0;
                        matrix[0][col] = 0;
                    }
                }
            }
        }
        for (int row = rows-1; row >= 1; row--){
            for(int col = cols - 1; col >= 1; col--){
                if (matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        if (firstColZero){
            for ( int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero){
            for ( int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }
    }
}

class SolutionSet {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if (matrix[row][col] == 0){
                    r.add(row);
                    c.add(col);
                }
            }
        }
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if (r.contains(row) || c.contains(col)){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
