class Solution {
    public int findDuplicate(int[] nums) {
        
        for ( int i = 0; i < nums.length; i++){
            while( nums[i] != i+1){
                if (nums[i] == nums[nums[i]-1]) return nums[i];
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        return 0; // just to compile
    }
}

/**

could we do something like puttinng the numbers in the correct spots?

[1,n]

for loop through nums
    while nums[index] != index+1 // not the "correct" value
        if (nums[index] == nums[nums[index]-1]) return nums[index];
        swap nums[index] and nums[nums[index]-1]


 */
