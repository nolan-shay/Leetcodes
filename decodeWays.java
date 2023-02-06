class Solution {
    public int numDecodings(String s) {
        int[] numSolutions = new int[s.length() + 1];
        numSolutions[s.length()] = 1;
        if ( s.charAt(s.length()-1) != '0'){
            numSolutions[s.length()-1] = 1;
        }
        for ( int pos = s.length()-2; pos >= 0; pos--){
            if ( s.charAt(pos) != '0'){
                numSolutions[pos] += numSolutions[pos+1];
            }
            int digOne = Character.getNumericValue(s.charAt(pos));
            int digTwo = Character.getNumericValue(s.charAt(pos+1));
            int sum = 10 * digOne + digTwo;
            if (sum > 9 && sum < 27){
                numSolutions[pos] += numSolutions[pos+2];
            }

        }
        return numSolutions[0];

    }
}

// class Solution {
//     public int numDecodings(String s) {
//         return decoder(s,0);
//     }

//     public int decoder( String s, int pos){
//         if ( pos == s.length()) return 1;
//         int single = 0;
//         int pair = 0;
//         if ( s.charAt(pos) != '0'){
//             single = decoder(s, pos+1);
//         }
//         if ( pos+1 < s.length()){
//             int digOne = Character.getNumericValue(s.charAt(pos));
//             int digTwo = Character.getNumericValue(s.charAt(pos+1));
//             int sum = 10 * digOne + digTwo;
//             if (sum > 9 && sum < 27){
//                 pair = decoder(s, pos+2);
//             }

//         }
//         return single + pair;
//     }
// }
