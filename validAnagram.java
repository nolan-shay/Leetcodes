class Solution {
    public boolean isAnagram(String s, String t) {
        int ocur[] = new int[26];

        for ( char c : s.toCharArray()){
            ocur[c-'a']++;
        }
        for ( char c : t.toCharArray()){
            ocur[c-'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (ocur[i] != 0){ return false;}
        }
        return true;
    }
}
