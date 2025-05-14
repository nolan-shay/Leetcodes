class Solution { // 5/14/25
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        nums[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        for (int i = nums.length-3; i>=0; i--){
            nums[i] = Math.max(nums[i]+nums[i+2], nums[i+1]);
        }
        return nums[0];
    }
}

/**

rob(0)
    if within bounds
    int rob = nums[0] + rob(2);
    int wait = rob(1);
    return max(rob,wait);

    0 depends on 1,2

 */

class Solution {
    public int rob(int[] nums) {
        //return robH(nums, 0);
        //base cases size = 1 or 2
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dpArr = new int[nums.length];
        dpArr[nums.length-1] = nums[nums.length-1];
        dpArr[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        int take, skip;
        
        for (int i = nums.length-3; i>=0; i--){
            take = nums[i] +dpArr[i+2];
            skip = dpArr[i+1];
            dpArr[i] = Math.max(skip,take);
        }
        
        return dpArr[0];    
        
    }
    
    // first developed recursion and made sure it worked, now to do some DP
    // public int robH(int[] nums, int start) {
    //     //base cases;
    //     if (start == nums.length-1){ return nums[nums.length-1];}
    //     if (start > nums.length -1 ) { return 0;}
    //     int take = nums[start] + robH(nums, start+2);
    //     int skip = robH(nums, start+1);
    //     return Math.max(take,skip);
    // }
}
