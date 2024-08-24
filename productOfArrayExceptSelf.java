class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashMap<String,Integer> hm = new HashMap<>();
        int end = nums.length -1;
        hm.put(toKey(0,0),nums[0]);
        hm.put(toKey(end,end),nums[end]);
        for(int i = 1; i < end; i++){
            hm.put(toKey(0,i), hm.get(toKey(0,i-1)) * nums[i] );
        }
        for(int i = end-1; i > 0; i--){
            hm.put(toKey(i,end), hm.get(toKey(i+1,end)) * nums[i] );
        }
        int[] ans = new int[nums.length];
        ans[0] = hm.get(toKey(1,end));
        ans[end] = hm.get(toKey(0,end-1));
        for(int i = 1; i < end; i++){
            ans[i] = hm.get(toKey(0,i-1)) * hm.get(toKey(i+1,end));
        }
        return ans;

    }

    public String toKey(int x, int y){
        return Integer.toString(x) + "," + Integer.toString(y);
    }
}

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            suffix[i] = nums[i]; //copy array
            if ( i > 0){ nums[i] =  nums[i-1] * nums[i];}
        }
        for( int i = nums.length - 2; i >= 0; i--){
            suffix[i] = suffix[i+1] * suffix [i];
        }
        suffix[0] = suffix[1];
        for ( int i = 1; i < nums.length-1; i++){
            suffix[i] = nums[i-1] * suffix[i+1];
        }
        suffix[nums.length-1] = nums[nums.length-2];

        return suffix;
    }
}
