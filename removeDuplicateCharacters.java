class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 'a'] ++;
        }
        return removeDupH(s, letters);
        
    }
    
    public String removeDupH(String s, int[] letters) {
        int index;
        String sub;
        boolean subWorks;
        int[] letters2 = new int[26];
        for (int i = 0; i < 26; i++){
            if (letters[i] > 0){
                index = s.indexOf((char)(i+'a'));  // bigO(n)
                sub = s.substring(index); // bigO(n)
                subWorks = true;
                for (int j = 0; j < sub.length(); j++){
                    letters2[sub.charAt(j) - 'a'] ++;   // bigO(n)
                }
                for (int j = 0; j < 26; j++){
                    if ( letters[j] > 0 && letters2[j] == 0){
                        subWorks = false;
                        break;
                    }
                }
                if (subWorks){
                    sub = s.substring(index+1);  // bigO(n)
                    letters[i] = -1;
                    return String.valueOf((char)(i+'a')) + removeDupH( sub, letters); //happens at most 26 times
                }
            }
        } return "";
        
    }
}
