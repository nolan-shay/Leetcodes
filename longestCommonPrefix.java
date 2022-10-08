class Solution {
    public String longestCommonPrefix(String[] strs) {
        int prefixLen = 0;
        char test;
        while(true){
            if (strs[0].length() > prefixLen){
                test = strs[0].charAt(prefixLen);
                for (int i = 0; i < strs.length; i++){
                    if (strs[i].length() <= prefixLen || strs[i].charAt(prefixLen) != test){
                        return strs[0].substring(0,prefixLen);
                    }
                }
                prefixLen++; 
            } else {
                    return strs[0].substring(0,prefixLen);
            }
        }
    }
}
