class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] targetFound = new boolean[3];

        for (int[] triplet : triplets){
            if ( triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                if ( triplet[0] == target[0]) targetFound[0] = true;
                if ( triplet[1] == target[1]) targetFound[1] = true;
                if ( triplet[2] == target[2]) targetFound[2] = true;
            } 
        }
        return targetFound[0] && targetFound[1] && targetFound[2];
    }
}

/**
if any triplet == target thats it
we do need the elements of target to be present somewhere to even consider it possible

we need to chose something where all elements are less than = target
does it matter if we do (i,j) or (j,i) ever?

am I positive we have the answer if we have thetarget element in the right place in "usable triplets"

targetFound = false,false,false

for triplet in triplets
    if no value in triplet is larger than that value in target
        if value in triplet == value in target, targetFound == true;
    if all found return true
    
return false;

 */
