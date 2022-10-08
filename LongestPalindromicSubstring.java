class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {return s;}
        String longestPalindrome = s.substring(0,1);
        String subStr;
        for (int i = 0; i < s.length() -1; i++){
            subStr = increasingSub(s,i,i+1, s.substring(i,i+1));
            if (subStr.length() > longestPalindrome.length()){
                longestPalindrome = subStr;
            }
            if (s.charAt(i) == s.charAt(i+1)){
                subStr = increasingSub(s,i,i+2, s.substring(i,i+2));
                if (subStr.length() > longestPalindrome.length()){
                    longestPalindrome = subStr;
                }
            }
            
            
        }
        System.out.println("this funcs longest is " + longestPalindrome);
        return longestPalindrome;
    }
    
    String increasingSub(String s, int start, int end, String curPalindrome){
        //only called by longest Palindrome with valid numbers, or by itself, checked first for valid               numbers
        //System.out.println("hello" + start + " " + end);
        //System.out.println(s.substring(start,end));
        if (isPalindrome(s.substring(start,end)) ){
            if ((start-1 >= 0 && end+1 <= s.length())){
                curPalindrome = s.substring(start,end);
            return increasingSub(s, start -1, end+1, curPalindrome);
            }else{
                return s.substring(start,end);
            }
        }else {
            return curPalindrome;
        }
        
    }
    
    public boolean isPalindrome(String p){
            StringBuffer str = new StringBuffer(p);
            StringBuffer reverse = new StringBuffer(p);
            reverse.reverse();
            return (str.toString().equals(reverse.toString()));
    }
}
