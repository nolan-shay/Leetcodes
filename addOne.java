class Solution {
    public int[] plusOne(int[] digits) {
        int pos = digits.length -1;
        int remainder = 1;
        while( pos>=0 && remainder ==1){
            if (digits[pos] + remainder == 10){
                digits[pos] = 0;
            } else{
                digits[pos] = digits[pos] + remainder;
                remainder = 0;
            }
            pos--;
        }
        if ( remainder == 1){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
