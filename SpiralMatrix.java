class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans= new ArrayList<>();
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;
        int top = 0;
        while ( right>= left && bottom >= top){
            for ( int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            if ( top != bottom){
                for (int i = right-1; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
            }
            if ( left != right){
                for (int i = bottom-1; i > top; i--){
                    ans.add(matrix[i][left]);
                }
            }
            right--;
            bottom--;
            left++;
            top++;
        }
        return ans;
       
    }
}
/*
right = 0
bottom = 1
top = 2
left = 2
while( right >= left && bottom >= top){

    //right
    for ( int z = left; z<= right; z++) (1,1)
        add matrix[top][z]
    //down
    for (int z = top+1; z <= bottom; z++) (2,1)
        add matrix[z][right]]
    //left
    if ( top!= bottom)
        for (int z = right-1; z >= left; z--) 
            add matrix[bnottom][z]]
    if ( left != right)
        for(int z = bottom-1; z> top; z--)
        add matrix[z][left];
    right--;
    bottom--;
    top++;
    left++;

}
*/
