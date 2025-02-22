class SolutionNeetcode {
    boolean found;
    public boolean canPartition(int[] nums) {
        found = false;
        int target = 0;
        for (int num: nums){
            target+= num;
        }
        if (target%2 == 1) return false;
        target = target/2;
        HashSet<Integer> sums = new HashSet<>();
        sums.add(0);
        for(int num : nums){
            HashSet<Integer> newSums = new HashSet<>();
            for ( int sum : sums) newSums.add(sum+num);
            for ( int sum : newSums) sums.add(sum);
            sums.add(num);
            if (sums.contains(target)) return true;
        }
        return false;
    }
}

class SolutionMemo {
    boolean found;
    int[][] memo;
    public boolean canPartition(int[] nums) {
        found = false;
        int sum = 0;
        for (int num: nums){
            sum+= num;
        }
        if (sum%2 == 1) return false;
        int target = sum/2;
        memo = new int[nums.length][target+1];
        return helper(nums,0,target);
    }

    public boolean helper( int[] nums, int pos, int target){
        if (found) return false;
        if (target < 0 || pos >= nums.length ) return false;
        if ( target == 0) return true;
        if (memo[pos][target] != 0) return memo[pos][target] == 1;
        boolean take = helper(nums,pos+1, target - nums[pos]);
        boolean skip = helper(nums,pos+1, target);
        boolean ans = take || skip;
        if (ans) found = true;
        if (ans){
            memo[pos][target] = 1;
        } else {
            memo[pos][target] = -1;
        }
        return ans;
    }
}
