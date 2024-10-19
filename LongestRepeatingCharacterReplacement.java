class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for ( int i = 0; i < s.length(); i++){
            for ( int j = i; j <= s.length(); j++){
                max = Math.max(max, canBeSwapped(s.substring(i,j), k));
            }
        }
        return max;
    }

    public int canBeSwapped(String s, int k){
        int max = 0;
        int maxPos = 0;
        int[] hm = new int[26];
        for (char c: s.toCharArray()){
            hm[c-'A']++;
            if (hm[c-'A'] > max){
                max = hm[c-'A'];
                maxPos = c-'A';
            }
        }
        int sum = 0;
        for ( int i = 0; i < 26; i++){
            if ( i != maxPos){
                sum += hm[i];
            }
        }
        if (sum <= k) return s.length();
        return 0;
    }
}

/**


canBeSwapped(String s, int k){
    int[] hm = new int[26];
    for (char c: String s){
        hm[c]++;
        if hm[c] > max, max = hm[c], maxPos = c;
    }
    for( i =0 i < 26 i++){
        if i != maxPos{
            sum += hm[i];
        }
    }
    if (sum <= k) return s.length;
    else return 0;
}

to figure out if a string and be changed to the same letter in k operations

we make a freq map
get the max value in the map. Then if the sum of all the other values <= k it can be done. 

if we did this for every substring


*/
