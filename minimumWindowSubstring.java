class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> hmT = new HashMap<>();
        HashMap<Character, Integer> hmS = new HashMap<>();
        for ( char ch : t.toCharArray()){
            if ( hmT.containsKey(ch)){
                hmT.put(ch, hmT.get(ch)+1);
            }
            else{
                hmT.put(ch,1);
            }
        }
        for ( char ch : s.toCharArray()){
            if (hmT.containsKey(ch)){
                if ( hmS.containsKey(ch)){
                    hmS.put(ch, hmS.get(ch)+1);
                }
                else{
                    hmS.put(ch,1);
                }
            }
        }

        // check if s is contained in t
        for ( Map.Entry<Character, Integer> me : hmT.entrySet()){
            if ( !hmS.containsKey(me.getKey()) || hmS.get(me.getKey()) < me.getValue() ){
                return "";
            }
        }
        int min = s.length();
        int start = 0;
        int end = s.length()-1;

        for ( int index = 0; index <= s.length() - t.length(); index++){
            while ( index < s.length() && !hmT.containsKey(s.charAt(index))){
                index++;
            }
            //index points at first char of interest starting at OG index value
            HashMap<Character,Integer> copyHM = new HashMap<>();
            for ( Map.Entry<Character,Integer> entry : hmS.entrySet()){
                copyHM.put(entry.getKey(), entry.getValue());
            }
            for ( int i = 0; i < index; i++){
                char ch = s.charAt(i);
                if ( copyHM.containsKey(ch)){
                    if ( copyHM.get(ch) <= hmT.get(ch)){   
                        return s.substring(start, end+1);
                    } else {
                        copyHM.put(ch, copyHM.get(ch) - 1);
                    }
                }
            }
            for (int i = s.length()-1; i >= index; i--){
                if ((i - index + 1) < min){
                    min = i - index + 1;
                    start = index;
                    end = i;
                }
                char ch = s.charAt(i);
                if ( copyHM.containsKey(ch) && copyHM.get(ch) <= hmT.get(ch)) break;
                else if ( copyHM.containsKey(ch) ){
                    copyHM.put(ch, copyHM.get(ch) - 1);
                }
            }

        }

        return s.substring(start, end+1);

    }
}
