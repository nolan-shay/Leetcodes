class Solution {
    public boolean isPalindrome(String s) {
        if ( s.length() == 0) return true;
        int start = 0, end = s.length() -1;
        while( start < s.length() && !isValidChar(s.charAt(start)) ) start++;
        while( end >= 0 && !isValidChar(s.charAt(end)) ) end--;

        while( start < end){
            if( Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
            while( !isValidChar(s.charAt(start)) ) start++;
            while( !isValidChar(s.charAt(end)) ) end--;
        }
        return true;

    }

    public boolean isValidChar( char ch){
        if ( ch-'A' >=0 && ch-'A' < 26 ) return true;
        if ( ch - 'a' >= 0 && ch -'a' < 26) return true;
        if ( ch-'0' >= 0 && ch-'0' < 10) return true;
        return false;
    }
}
