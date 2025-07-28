class Solution { //jul 25 2025
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int start = 0;
        int max = 0;
        
        for ( int end = 0; end < s.length(); end++){
            char chEnd = s.charAt(end);
            char chStart = s.charAt(start);
            map[chEnd-'A']++;
            if ( (end - start +1) - getMax(map) > k){
                map[chStart-'A']--;
                start++;
            }
            max = Math.max(end - start +1,max);
        }
        return max;
    }

    public int getMax(int[] map){
        int max = 0;
        for(int x : map) { max = Math.max(max,x);}
        return max;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int pointer1 = 0;
        int pointer2 = 0;
        int[] freq = new int[26];
        int max = 1;
        freq[ s.charAt(0) - 'A'] = 1;
        while(true){
            while ( (pointer2 - pointer1 +1) - getMaxChar(freq) <= k ){
                if ((pointer2 - pointer1 +1) > max) max = pointer2 - pointer1 + 1;
                pointer2++;
                if (pointer2 == s.length()) return max;
                freq[s.charAt(pointer2) - 'A']++;
            }
            while ( (pointer2 - pointer1 +1) - getMaxChar(freq) > k ){
                freq[s.charAt(pointer1) - 'A']--;
                pointer1++;
            }
        }

        
    }
    // returns max freq
    public int getMaxChar(int[] nums){
        int max = 0;
        for (int i : nums){
            if ( i > max) max = i;
        }
        return max;
    }
}

/*
2 pointer where we build a sequence up while ( sub.length - number most freq character <= k )
    if < k then we keep track of a max length
then we shrink while ( sub.length - number of most freq character > k) 
we can stop once last pointer is last value


get Max Char ( int[] freq)){
    for loop find the max
}

return the max


*/
