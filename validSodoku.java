class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Integer>[] sets = new HashSet[27];
        for ( int i = 0; i < 27; i++){
            sets[i] = new HashSet<>();
        }
        int x;
        HashSet hs;
        for (int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] != '.'){
                    x = Character.getNumericValue(board[row][col]);
                    hs = sets[row+9];
                    if ( !checkHashSet(hs,x)) {return false;}
                    hs = sets[col+18];
                    if ( !checkHashSet(hs,x)) {return false;}
                    hs = sets[getBox(row,col)];
                    if ( !checkHashSet(hs,x)) {return false;}
                }
            }
        }

        return true;
        
    }

    public boolean checkHashSet(HashSet<Integer> hs, int x){
        if (hs.contains(x)){
            return false;
        }else{ 
            hs.add(x);
            return true;
        }
    }

    public int getBox(int row, int col){
        int box;
        if (col <3){box = 0;}
        else if ( col<6){ box = 1;}
        else {box = 2;}

        if (row < 3){return box;}
        else if ( row < 6){return box+3;}
        else { return box+6;}
    }



    /*
    have 27 hashsets and then at each position 0,0 we we would add the value to a hashset that represented row0, column0, and box0 and have a formula for which row/col/box we are adding too

array of 27 
    0-8 represent boxes 0-8 
    9-17 represent row 0-8 formula hashset = row+9
    18-26 represent col 0-8 formula hashset = col+18

    getBox(a,b)
        if col < 3
            box = 0
        else if col <6
            box = 1
        else box = 2;
        
        if row < 3 return box
        else if row<6 return box+3
        else return box+6
        */
}
