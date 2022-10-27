class Solution(object):
    def maxSubArray(self, nums):
        if len(nums) == 1:
            return nums[0]
        max = nums[len(nums) -1 ];
        # range( inclusive, exclusive)
        for i in range(len(nums)-2,-1,-1):
            if ( nums[i] < nums[i] + nums[i+1]):
                nums [i] = nums[i] + nums[i+1]
            if (nums[i] > max):
                max = nums[i]
        return max
        """
        :type nums: List[int]
        :rtype: int
        """
        
