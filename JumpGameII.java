class Solution { // 6/2025
    public int jump(int[] nums) {
        int hops = 0, min = 0, max = 0, nextMax = 0;
        while ( min < nums.length){
            for ( int i = min; i <= max && i < nums.length; i++){
                nextMax = Math.max(nextMax, i + nums[i]);
            }
            hops++;
            min = max+1;
            max = nextMax;
        }
        return hops-1;
    }
}
