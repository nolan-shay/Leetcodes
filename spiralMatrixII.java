class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        //if( n ==1 ) 
        int bottom = n-1;
        int top = 0;
        int left = 0;
        int right = n-1;

        int counter = 1;

        while ( bottom >= top){
            for ( int i = left; i <= right; i ++){
                answer[top][i] = counter;
                counter++;
            }
            top++;
            for ( int i = top; i <= bottom; i ++){
                answer[i][right] = counter;
                counter++;
            }
            right--;
            for ( int i = right; i >= left; i--){
                answer[bottom][i] = counter;
                counter++;
            }
            bottom--;
            for ( int i = bottom; i >= top; i--){
                answer[i][left] = counter;
                counter++;
            }
            left++;

        }

        return answer;


    }
}
