class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //positions in one quarter of the matrix, excludes center of odd n x n matrix bc that doesn't need rotated
        //.... draw a picture!
        for( int i = 0; i < n/2; i++){
            for (int j = i; j < n-i-1; j++){
                rotatePos(matrix,i,j);
                System.out.println(i+","+j);
            }
        }
    }
    
    public void rotatePos(int[][] matrix, int i, int j) {
        int n = matrix.length;
        //temp = pos1
        int temp = matrix[i][j];
        //pos1 = pos4
        matrix[i][j] = matrix[n-1-j][i];
        //pos4 = pos3
        matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        //pos3 = pos2
        matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        //pos2 = temp
        matrix[j][n-1-i] = temp;
    }
}
