class Solution {
public:

    unordered_map<int, unordered_map< int, int>> map;

    int findTargetSumWays(vector<int>& nums, int target) {
        return helper(nums, target, 0);
    }

    int helper( vector<int>& nums, int target, int pos){
        if (map.contains(target) && map[target].contains(pos)){
            return map[target][pos];
        }
        if (pos == nums.size()){
            if (target == 0) return 1;
            return 0;
        }

        int cur = nums[pos];
        int sum = 0;
        sum += helper(nums, target+cur, pos+1);
        sum += helper(nums, target-cur, pos+1);
        map[target][pos] = sum;
        return sum;
    }
};

/*

2 choices per num

2nd method that 

int helper( nums, target, pos)
    is pos at the end and target == 0? if so return 1;
    cur = nums[pos];
    sum = 0; 

    sum += helper(nums, target - cur, pos+1)
    sum += helper(nums, target+ cur, pos+1)
    return sum;

    o(2^n)


instead wee have a matrix
*/
