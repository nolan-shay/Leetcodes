class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max=0;
        int maxKey= nums[0];
        int val = 0;

        for (int i : nums){
            if (hm.containsKey(i)){
                val = hm.get(i)+1;
                if (val > max){
                    max = val;
                    maxKey = i;
                }
                hm.put(i, val );
            }else{
                hm.put(i,1);
            }

        }

        return maxKey;
        
    }
}

/*

iterate over nums
    keep track of each nums freq in hashmap where key = nums[i], value = freq
    if contains +=
    else add key,1
    keep track of a max and maxkey; 

nums = [2,2,1,1,1,2,2]

hashmap{
    2,4
    1,3
}

maxkey = 2
max = 4

*/

class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int maj = 0;

        for (int i : nums){
            if (maj == 0){ res = i;}
            if (res == i){
                maj++;
            } else {
                maj--;
            }
        }

        return res;
    }

}

/*

so we know that the majority element shows up more than half the time, meaning it shows up more than all other elements combined, so if we can keep track kof how often we see an element vs how often we see any other element, we will find the majority. 

*/
