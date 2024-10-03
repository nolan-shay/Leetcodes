class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if ( n== 1) return nums[0];
        if ( n == 2) return Math.min(nums[0],nums[1]);
        if ( nums[n-1] > nums[0]) return nums[0];
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;
        while(end-start > 1){
            if (nums[mid] > nums[start]){
                start = mid;
            } else {
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        return nums[end];
        
    }
}

/*

start = 0
end = n-1
int mid = start + ((end-start)/2)

while ( end - start > 1){
    if nums[mid] > nums[start] {
        start = mid;
    } else {
        end = mid;
    }
    mid = start + (start-end)/2
}

return nums[start]

5 7 0 1
7 0 1
*/
