class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++){
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }
        return Math.max( robHelper(nums1), robHelper(nums2));
    }

    public int robHelper(int[] nums){
        if ( nums.length == 1) return nums[0];
        if ( nums.length == 2) return Math.max(nums[0],nums[1]);
        nums[nums.length-2] = Math.max(nums[nums.length-2],nums[nums.length-1]);
        for ( int i = nums.length-3; i>=0; i--){
            nums[i] = Math.max( nums[i] + nums[i+2], nums[i+1]);
        }
        return nums[0];
        
    }
}

/**
lets do 1d dp on two arrays
one where you choose first house // you cant choose last house
one where you don't choose first // you can choose last



isFirstChosen = true
chooseFirst = nums[0] + robHelper(2);

isFirstChosen = false;
dontChooseFirst = robHelper(1); 
return max pf chooseFirst, don't choose first

robHelper(i)
    if i >= nums.length return 0
    if i == nums.length-1 and isFirstChosen
        return 0;
    int take = nums[i] + robHelper(i+2);
    int skip = robHelper(i+1);
    return Max(take,skip)


 */
