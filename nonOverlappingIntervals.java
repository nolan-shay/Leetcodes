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

class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] -b[1]);

        int[] chosen = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++){
            if ( intervals[i][0] < chosen[1]){
                count++;
            } else {
                chosen = intervals[i];
            }
        }
        return count;

    }
}
/*
sort based on end time
choose first entry (it ends first)
then choose the next item in the list that has start time after last scheduled end time
    that is now current item

sort based on end time

chosen = intervals[0]
count = 0;
for ( int i = 1; i< intercals; i++)
    if intervals[i][0] < chosen[1] //this means that there is interference
        count ++;
    else 
        chosen = intervals[i]
    */

