class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int pointer1 = 0;
        int pointer2 = 1;
        int counter = 0;
        while(pointer2 < intervals.length){
            if (intervals[pointer2][0] < intervals[pointer1][1]){ //ie interterference
                if (intervals[pointer2][1] > intervals[pointer1][1]){
                    pointer2++;
                }else {
                    pointer1++;
                    pointer2++;
                }
                counter++;
            } else {
                pointer1++;
                pointer2++;
            }
        }
        return counter;
        
    }
}
