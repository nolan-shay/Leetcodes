class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        HashSet<Integer> hs = new HashSet<>();
        int count;
        int first = -1;
        for ( int[] interval : intervals){
            count= 0;
            for ( int i = interval[0]; i <= interval[1]; i++){
                if (hs.contains(i)){
                    count++;
                    if ( count > 1){
                        System.out.println( interval[0] + "," + interval[1] + " " + i);
                        return false;
                    }
                }else {
                    count = 0;
                    hs.add(i);
                }
            }
        }
        return true;
    }

}

/*
    we will need to account for the fact that two meetings only interferee if the start/emd time are within the others bounds, they can be on the edge.

    canAttend(intervals)
    for(interval: intervals){
        count = 0;
        for int i = interval[0] to interval[1] inclusive 
            if (hs.contains(i){
                count++;
                if (count > 1) return false
            } else {
                hs.add(i);
            }
    }

 */

class Solution2 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for ( int i = 1; i < intervals.length; i++){
            if( intervals[i][0]  < intervals[i-1][1]) { return false;}
        }
        return true;
    }

}
