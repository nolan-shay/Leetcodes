class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length -1;
        while (numbers[ptr1] + numbers[ptr2] != target){
            if(numbers[ptr1] + numbers[ptr2] > target){
                ptr2--;
            } else {
                ptr1++;
            }
        }
        return new int[]{ptr1+1, ptr2+1};
    }
}
/*

ptr1 = 0
ptr2 = len-1

while( sum of values of ptr1 and ptr2 != target) {
    if > target
        ptr2-- // makes the sum smaller
    else ptr1++  // makes the sum larger
}

*/
