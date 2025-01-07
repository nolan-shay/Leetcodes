class Solution {
    public int maxArea(int[] heights) {
        int ptr1 = 0;
        int ptr2 = heights.length -1;
        int max = 0;
        while(ptr2>ptr1){
            max = Math.max(max,(ptr2-ptr1) * Math.min(heights[ptr1], heights[ptr2]));
            if (heights[ptr1] < heights[ptr2]){
                ptr1++;
            } else ptr2--;
        }
        return max;
    }
}

/*
containerSize = max( heights[ptr1], heights[ptr2]) * (ptr2-ptr1);



n^2
for ( int ptr1 = 0...
    for ( int ptr2 = ptr1+1...
        compare and keep a max



*/
