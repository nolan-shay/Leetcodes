class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = nums.length -2; i >= 0; i--){
            if (nums[i] + nums[i+1] > nums[i] ){
                nums[i] = nums[i+1] + nums[i];
            }
        }
        
         for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }

        return max;
        
    }
}
