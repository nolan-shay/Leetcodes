class Solution {
    public String countAndSay(int n) {
        //base case
        if (n == 1) { return "1";}
        // recurse on n-1 and add onto it somehow..
        String prev = countAndSay(n-1);
        StringBuffer ans = new StringBuffer();
        int count = 1;
        char ch = prev.charAt(0);
        int i = 1;
        char curChar;
        while(i < prev.length()){
            curChar = prev.charAt(i);
            if( curChar != ch){
                //ans = ans + Integer.toString(count) + ch;
                ans.append(Integer.toString(count) + ch);
                ch = curChar;
                count = 1;
            }else{
                count++;
            }
            i++;
        }
        ans.append(Integer.toString(count) + ch);
        
        return ans.toString();
    }
}
