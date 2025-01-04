class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        int ptr1, ptr2, target;
        for( int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);

        }
        for (int i = 0; i < nums.length; i++){
            ptr1 = i+1;
            ptr2 = nums.length-1;
            target = -(nums[i]);
            while( ptr2 > ptr1){
                if ( nums[ptr1] + nums[ptr2] < target){
                    ptr1++;
                } else if ( nums[ptr1] + nums[ptr2] > target ){
                    ptr2--;
                } else {
                    hs.add(List.of(-target, nums[ptr1], nums[ptr2]));
                    ptr1++;
                    ptr2--;
                }
            }
        }
        //convert hs to List;
        List<List<Integer>> ans = new ArrayList<>();
        for( List<Integer> e : hs){
            ans.add(e);
        }
        return ans;
    }
}
/*
sort the array, now we have the issue of twoSum sorted array
where we don't know for sure if there are more than one solytion or no solytion


[-5,1,2,2,3,3,4,x]
target = 5, ptr1 = 1, ptr2 = 4
hs.add(5,2,3)
sort array.
hashSet<List<Integer>> hs =

for ( int i = 0; i < nums.length; i++)
    ptr1 = i+1;
    ptr2 = nums.length-1;

    while( ptr2<=ptr1)
        if ptr1 + ptr2 > target
            ptr2--
        else if  < target
            ptr1++
        else if equals target
            hs.add (-target, nums ptr1, nums ptr2) // always ascending order
            ptr1++
            ptr2--



*/
