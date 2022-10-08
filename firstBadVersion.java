/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //starts at 1
        if (n==1) { return 1;}
        return firstBadVersionH(1,n);
    }
    
    public int firstBadVersionH(int start, int end) {
        //base cases
        if (start == end) { return start;}
        if ( (end - start) == 1){
            if (isBadVersion(start)){ return start;}
            return end;
        }
        //overflow to be avoided by this midle computation
        int middle = start + (end - start) / 2; // auto floors bc int division
        if (isBadVersion(middle)){
            return firstBadVersionH(start, middle);
        }else {
            return firstBadVersionH(middle+1, end); // make sure to account for +1 in base cases
        }
        
    }
}
