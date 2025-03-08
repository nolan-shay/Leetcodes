class Solution {
    public int minDistance(String word1, String word2) {
        int [][] arr  = new int[word1.length() +1][word2.length()+1];
        int cur = 0;
        for (int i = word1.length(); i >= 0; i --){
            arr[i][word2.length()] = cur;
            cur++;
        }
        cur = 0;
        for ( int i = word2.length(); i >= 0; i--){
            arr[word1.length()][i] = cur;
            cur++;
        }
        int replace,insert,delete;
        for ( int row = word1.length()-1; row >=0; row--){
            for (int col = word2.length()-1; col >=0; col--){
                replace = 1+arr[row+1][col+1];
                insert = 1+arr[row][col+1];
                delete = 1+arr[row+1][col];
                if ( word1.charAt(row) == word2.charAt(col)) replace = replace-1;
                arr[row][col] = Math.min(Math.min(replace,insert),delete);
            }
        }

        return arr[0][0];

    }
}

/**

recurse ( word1, word2, ptr1, ptr2) {
    if ptr1 and ptr2 are at word1 and word2.lenght return 0
    if ptr1 = word1.length return word2.length - ptr2
    if ptr2 = word2.length return word1.length - ptr1
    replace = 1 + recurse(word1,word2,ptr1,ptr2)
    if the character at ptr1,ptr2 are equal, replace = replace -1;
    insert = 1 + recurse( ptr1, ptr2+1)
    delete = 1 + recurse( ptr1+1, ptr2)
    return min( replace, insert, delete)



}


 */
