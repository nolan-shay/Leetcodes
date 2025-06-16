class Solution {

    String[][] letters = {
        {},
        {},
        {"a","b","c"},
        {"d","e","f"},
        {"g","h","i"},
        {"j","k","l"},
        {"m","n","o"},
        {"p","q","r","s"},
        {"t","u","v"},
        {"w","x","y","z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        if (digits.length() == 1) return List.of(letters[Character.getNumericValue(digits.charAt(0))]);
        int digit = Character.getNumericValue(digits.charAt(0));
        List<String>  children = letterCombinations( digits.substring(1,digits.length()));
        for ( String s : letters[digit]){
            for (String child : children){
                ans.add(s+child);
            }
        }
        return ans;
    }
}
