class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        for ( int i = 0; i < nums.length; i++){
            LIS[i] = 1;
        }
        int max = 1;
        for (int i = nums.length -2; i >=0; i--){
            for (int j = i+1; j < nums.length; j++){
                if ( nums[i] < nums[j]){
                    if (LIS[j] + 1 > LIS[i]) {
                        LIS[i] = LIS[j]+1;
                        if (LIS[i] > max) max = LIS[i];
                    }
                }
            }
        }
        return max;
    }

}

// 2/20/2025
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length+1];
        Arrays.fill(LIS, -999999);
        LIS[1] = nums[nums.length-1];
        int upperbound = 1;
        for(int i = nums.length-2; i >= 0; i--){
            int maxLength = getMaxLength(LIS,upperbound,nums[i]);
            int length = maxLength+1;
            LIS[length] = Math.max(LIS[length],nums[i]);
            upperbound = Math.max(upperbound,length);
        }
        return upperbound;
    }

    //pos of the number at highest pos (below and including hi) > candidate
    public int getMaxLength(int[] LIS, int hi, int candidate){
        int lo = 1;
        int mid= 1;
        while ( lo < hi-1){
            mid = lo + (hi-lo)/2;
            if ( candidate > LIS[mid]){ 
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (LIS[hi] > candidate) return hi;
        if (LIS[lo] > candidate) return lo;
        return 0;
    }
}
