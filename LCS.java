class SolutionDPOptimized {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arrLCS = new int[2][text2.length()+1];
        for ( int pos1 = text1.length()-1; pos1 >= 0; pos1--){
            for (int pos2 = text2.length()-1; pos2 >= 0; pos2--){
                int take = 0, skip1 = 0, skip2 = 0;
                if (text2.charAt(pos2) == text1.charAt(pos1)){
                    take = 1 + arrLCS[1][pos2+1];
                }
                skip1 = arrLCS[1][pos2];
                skip2 = arrLCS[0][pos2+1];

                arrLCS[0][pos2] = Math.max(Math.max(skip1,skip2), take);

            }
            arrLCS[1] = arrLCS[0];
            arrLCS[0] = new int[text2.length()+1];
        }
        return arrLCS[1][0];
    }
}

class SolutionDP {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arrLCS = new int[text1.length()][text2.length()];
        for ( int pos1 = text1.length()-1; pos1 >= 0; pos1--){
            for (int pos2 = text2.length()-1; pos2 >= 0; pos2--){
                int take = 0, skip1 = 0, skip2 = 0;
                if (text2.charAt(pos2) == text1.charAt(pos1)){
                    take++;
                    if ( pos1+1 < text1.length() && pos2+1 < text2.length()) take += arrLCS[pos1+1][pos2+1];
                }
                if ( pos1+1 < text1.length()) skip1 = arrLCS[pos1+1][pos2];
                if ( pos2+1 < text2.length()) skip2 = arrLCS[pos1][pos2+1];

                arrLCS[pos1][pos2] = Math.max(Math.max(skip1,skip2), take);

            }
        }
        return arrLCS[0][0];
    }
}

class SolutionMemoization {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arrLCS = new int[text1.length()][text2.length()];
        return LCSH( text1, text2, 0, 0, arrLCS);
    }

    public int LCSH( String text1, String text2, int pos1, int pos2, int[][] arrLCS){
        if ( pos1 >= text1.length() || pos2 >= text2.length()) return 0;
        if (arrLCS[pos1][pos2] != -1) return arrLCS[pos1][pos2];
        int pos1OG = pos1;
        int pos2OG = pos2;
        int take = 0;
        int skip = LCSH( text1, text2, pos1+1, pos2, arrLCS);
        while ( pos2 < text2.length() && text2.charAt(pos2) != text1.charAt(pos1)) pos2++;
        if ( pos2 != text2.length()) take = 1 + LCSH( text1, text2, pos1+1, pos2+1, arrLCS);

        arrLCS[pos1OG][pos2OG] = Math.max(skip,take);
        return arrLCS[pos1OG][pos2OG];

    }
}
