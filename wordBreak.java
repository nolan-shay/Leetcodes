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
