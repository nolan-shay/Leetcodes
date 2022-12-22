class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) { return; }
        int pos = -1;
        for ( int i = nums.length - 2; i >= 0; i--){
            if ( nums[i] < nums[i+1]){
                pos = i;
                break;
            }
        }
        if (pos == -1){
            // reverse array!!!
            reverse(nums,0);
            return;
        }
        int next = pos+1;
        for ( int i = pos+2; i < nums.length; i++){
            if ( nums[i] <= nums[next] && nums[i] > nums[pos]){
                next = i;
            }
        }
        //swap
        int temp = nums[pos];
        nums[pos] = nums[next];
        nums[next] = temp;
        reverse(nums, pos+1);

        return;
    }
    public void reverse(int nums[], int front){
        int end = nums.length-1;
        int temp;
        while ( end - front >= 1){
            temp = nums[front];
            nums[front] = nums[end];
            nums[end] = temp;
            front++;
            end--;
        }

    }
}
