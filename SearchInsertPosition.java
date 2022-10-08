class Solution {
    public int searchInsert(int[] nums, int target) {
        return recur(nums, 0, nums.length-1, target);
    }
   
    public int recur(int[] nums, int bound1, int bound2, int target){
        if ( (bound1 != bound2) &&  ((bound2 -bound1) != 1)  ){
            int middle = (bound1 + bound2) / 2;
            if (target == nums[middle]) { return middle;}
            if (target > nums[middle]){
                return recur(nums, middle+1, bound2, target);
            }else {
                return recur(nums, bound1, middle-1, target);
            }
        } else {
            if(target <= nums[bound1]){
                return bound1;
            } else if (target <= nums[bound2]){
                return bound2;
            } else {
                return bound2+1;
            }
        }
    }
}
