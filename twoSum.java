class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}

//Solution 2 with hash table

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            //check current hm for target - nums[i]
            if (hm.get(target-nums[i]) != null && hm.get(target-nums[i]) != i){
                ans[0] = i;
                ans[1] = hm.get(target - nums[i]);
                return ans;
            }
            //important to put this after we check for cases like [3,3] target 6
            hm.put(nums[i], i);
        }
        
        return ans;
    }
}
