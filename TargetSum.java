class Solution {
    HashMap<List<Integer>,Integer> hm;
    public int findTargetSumWays(int[] nums, int target) {
        hm = new HashMap<>();
        return findTargetHelper(nums,target,0);
    }

    public int findTargetHelper( int[] nums, int target, int pos){
        if (pos == nums.length) return target == 0? 1 : 0;
        List<Integer> key = List.of(target,pos);
        if ( hm.containsKey(key)) return hm.get(key);
        int negative = findTargetHelper(nums,target - nums[pos], pos+1);
        int positive = findTargetHelper(nums,target + nums[pos], pos+1);
        hm.put(key, negative+positive);
        return hm.get(key);
    }
}

/**




int[] nums int target
each number can be positive or negative
how many ways can we make target.

findTargetSumWays(nums,target)
    findTargetRec( nums, target, 0, 0)

findTargetRec(nums,target, pos)
    if pos == nums.length return 0
    if pos == nums.length - 1 and target == 0 return 1
    negative = findtargetRecc(nums,target - nums[pos], pos+1)
    positive = findtargetRecc(nums,target - nums[pos], pos+1)
    return negative + positive


 */
