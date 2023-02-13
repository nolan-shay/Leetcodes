class Solution {
    public int maxProduct(int[] nums) {
        int[] maxes = new int[nums.length];
        int[] mins = new int[nums.length];
        int max = nums[nums.length-1];
        maxes[nums.length-1] = nums[nums.length-1];
        mins[nums.length-1] = nums[nums.length-1];

        for ( int i = nums.length-2; i >=0; i--){
            maxes[i] = Math.max(Math.max( nums[i], nums[i] * maxes[i+1]),nums[i] * mins[i+1]);
            mins[i] = Math.min(Math.min( nums[i], nums[i] * maxes[i+1]),nums[i] * mins[i+1]);
            if ( maxes[i] > max) max = maxes[i];

        }

        return max;
    }
}

/*

    initialize min and max array of same size of nums, last positions = last position of nums
    loop towards beginning of nums, keeping track of max and min possible subarrays starting at that index.
        max[i] = MAth.max( nums[i], nums[i] * max[i+1], nums[i] * min[i+1])
        min[i] = Math.min( nums[i], nums[i] * max[i+1], nums[i] * min[i+1])
        if max[i] > max then max = max[i];

    return max;

*/
