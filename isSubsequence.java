class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer1 = 0;
        int pointer2 = 0;

        while( pointer1 < s.length() && pointer2 < t.length()){
            if(s.charAt(pointer1) == t.charAt(pointer2)){
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
            }
        }
        
        return pointer1 == s.length();

    }
}

/*
2 pointer method


pointer1 points to s first char
pointer2 points to t first char

while ( pointer1 and pointer 2 are both less than the length of s and t respectively)

if (pointer1.char == pointeer2.char)
  ++ both
else ++ pointer2

if we are at the end of s return true, else return false;
*/
