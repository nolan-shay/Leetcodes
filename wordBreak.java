class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        int[] arrDP = new int[s.length()];
        for ( String word : wordDict){
            wordSet.add(word);
        }
        return wordBreak(s, wordSet, arrDP);
    }

    public boolean wordBreak(String s, HashSet<String> wordSet, int[] arrDP){
        if (s.length() == 0) return true;
        if ( arrDP[ arrDP.length - s.length() ] == -1 ) return false;
        StringBuilder token = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            token.append(s.charAt(i));
            String tokenStr = token.toString();
            if (wordSet.contains(tokenStr) ){
                boolean take = wordBreak(s.substring(i+1, s.length()), wordSet, arrDP);
                if (take) return true;
            }
        }
        arrDP[ arrDP.length - s.length() ] = -1;
        return false;
    }
}

//2/22/2025
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>();
        for (String word : wordDict) words.add(word);
        boolean[] sub = new boolean[s.length()];
        for (int i = s.length()-1; i >=0; i--){
            if (words.contains(s.substring(i,s.length()))) sub[i] = true;
            else {
                for (int j = i+1; j < s.length(); j++){
                    if (sub[j] && words.contains(s.substring(i,j))){
                        sub[i] = true;
                        break;
                    }
                }
            }
        }
        return sub[0];
    }
}
