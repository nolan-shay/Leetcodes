class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        
        while( n != 1 && !hs.contains(n)) {
            hs.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n){
        int sum = 0;
        while( n > 0){
            int dig = n % 10;
            sum+= dig*dig;
            n = n/10;
        }
        return sum;
    }
}

/*

add n to set
get nextNumber(n)
if n is in the set return false
if n is 1 return true;

    get next number(n)
    sum = 0
        while ( n > 0)
        dig = n % 10
        sum += dig * dig
        n = n/10;
    
*/
