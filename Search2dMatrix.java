class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = (matrix.length * matrix[0].length)-1;
        int cols = matrix[0].length;
        int mid;
        while ( start <= end){
            mid = start + (end - start)/2;
            if (matrix[mid/cols][mid%cols] == target) return true;
            if (matrix[mid/cols][mid%cols] > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
