class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] path = new boolean[s1.length()+1][s2.length()+2];
        path[s1.length()][s2.length()] = true;
        for( int row = s1.length(); row >=0; row--){
            for (int col = s2.length(); col >=0; col--){
                if (!path[row][col]){
                    if( col < s2.length() && s3.charAt(row+col) == s2.charAt(col) && path[row][col+1]){
                        path[row][col] = true;
                    }else if ( row < s1.length() && s3.charAt(row+col) == s1.charAt(row) && path[row+1][col] ){
                        path[row][col] = true;
                    }
                }
            }
        }
        return path[0][0];
    }
}

/**

if s1 +s2 .length != s3 return false;

isInterleave ( s1,s2,s3,p1,p2,p3) //pointers initially all 0
    if p3 == s3.length return true;
    if p1 < s1.length and s1.charAt(p1) == s3.chaAt(p3)
        take1 = isInterleave(p1++,p2,p3++);
    if p2 < s2.length and s2.charAt(p2) == s3.chaAt(p3)
        take2 = isInterleave(p1,p2++,p3++);
    return take1 || take2

 col < s2.length and s3.charAt(row +col) == s2.charAt(col) and path[row][col++];
    path[row][col] = true;
 row < s1.length and s3.charAt(row +col) == s1.charAt(row) and path[row++][col];
    path[row][col] = true;

 */
 
