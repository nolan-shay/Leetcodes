class Solution {
    public int longestConsecutive(int[] nums) {
        if ( nums.length == 0) return 0;
        if ( nums.length == 1) return 1;
        int max = 1;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for( int x : nums){
            if (!hm.containsKey(x)){
                if (hm.containsKey(x-1) && hm.containsKey(x+1)){
                    hm.put(x,x);
                    int start = hm.get(x-1);
                    int end = hm.get(x+1);
                    hm.put(end,start);
                    hm.put(start,end);
                    if ( ((end-start) +1) > max) max = ((end-start) +1);
                } else if (hm.containsKey(x-1)){
                    hm.put(x,hm.get(x-1));
                    int start = hm.get(x);
                    hm.put(start,x);
                    if ( ((x-start) +1) > max) max = ((x-start) +1);
                } else if (hm.containsKey(x+1)){
                    hm.put(x,hm.get(x+1));
                    int end = hm.get(x);
                    hm.put(end,x);
                    if ( ((end-x) +1) > max) max = ((end-x) +1);
                } else {
                    hm.put(x,x);
                }
            }
        }
        return max;
        
    }
}

/*/HashMap where if you are the start of an interval, you contain the end of a list
when you look at a number 
    if x is present, do nothing
    if x-1 and x+1 present
        hm.put(x,x)
        start = hm.get(hm.get(x-1));
        end = hm.get(hm.get(x+1));
        hm.put(end,start)
        hm.put(start,end);
        calculatte length
    if x-1 is present
        hm.get(x) = hm.get(x-1);
        hm.get(hm.get(x)) = x;
        record length
    if x+1 is present and not
        hm.get(x) = hm.get(x+1);
        hm.get(hm.get(x)) = x;
        record length

        */
