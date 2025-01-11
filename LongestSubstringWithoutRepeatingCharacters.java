class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ptr1 =0, ptr2 = 0, max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();

        while(ptr2 < s.length()){
            while(ptr2<s.length() && ( !hm.containsKey(s.charAt(ptr2)) || hm.get(s.charAt(ptr2)) == 0)){
                max = Math.max(max,ptr2-ptr1+1);
                hm.put(s.charAt(ptr2),1);
                ptr2++;
            }
            if(ptr2 < s.length()){
                hm.put(s.charAt(ptr2),2);
                while( hm.get(s.charAt(ptr2)) == 2){
                    hm.put(s.charAt(ptr1), hm.get(s.charAt(ptr1)) -1);
                    ptr1++;
                }
                ptr2++;
            }
        }

        return max;
    }
}
/**
hm< char, numOccur>

ptr1 = 0
ptr2 = 0
max = 0;
while( ptr2 < s.length)
    while ( ptr2 < s.length && (!hm.contains(ptr2) || hm.get(ptr2) == 0))
        max = ptr2-ptr1 +1
        hm.put(ptr2,1)
        ptr2++
    if( ptr1 < s.length) hm.put(ptr2, 2)
    while(hm.get(ptr2) == 2){
        hm.put( ptr1, hm.get(ptr1) -1 )
        ptr1++;
    }
return max;

increase ptr2 until there is a repeat keeping track of max
(numOccur > 1 for any char)
once that happens increase ptr1 until we no longer have a repeat

doubts:
can we skip over any valid substrings in this method
no

**/
