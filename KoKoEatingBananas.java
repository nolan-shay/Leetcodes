class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = 1;
        for ( int pile : piles){
            hi = Math.max(pile,hi);
        }
        int lo = 1;
        int mid, hours;
        while( hi > lo+1){
            mid = lo + (hi-lo)/2;
            hours = evaluate(mid, piles);
            if (hours > h){
                lo = mid;
            }else {
                hi = mid;
            }
        }
        if (evaluate(lo,piles) <= h) return lo;
        return hi;

    }

    public int evaluate( int mid, int[] piles){
        int sum = 0;
        for (int pile :piles){
            double hours = (double) pile / (double) mid;
            sum += (int) Math.ceil(hours);
        }
        return sum;
    }
}

/** 
n == h, k = largest pile
n == h+1 max(2nd largest pile or Ceil(half of largest pile) )
n == h +  2

 say we have a sorted piles[i] you know that if you choose a speed of a pile, all piles to the left will be 1, but its unkown what the piles to the right will be

 if you choose each pile and evaluate it as an option
 given we choose the speed of pile i, then we know we have 
 (i+1) hours including this pile and all to the left, then we would have to see what everythign to the right added to 

 */
