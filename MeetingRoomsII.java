class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int mid,start,end,max=0;
        for (int[] interval : intervals){
            mid= 0;
            start = 0;
            end =0;
            for ( int[] iter : intervals){
                if ( interval[0] == iter[0]) start ++;
                else if ( interval[0] == iter[1]) end ++;
                else if ( iter[0] < interval[0] && interval[0] < iter[1]) mid ++;
            }
            max = Math.max( max, (mid + Math.max(start,end)));
            mid= 0;
            start = 0;
            end =0;
            for ( int[] iter : intervals){
                if ( interval[1] == iter[0]) start ++;
                else if ( interval[1] == iter[1]) end ++;
                else if ( iter[0] < interval[1] && interval[1] < iter[1]) mid ++;
            }
            max = Math.max( max, (mid + Math.max(start,end)));
        }
        return max;
        
    }
}

/*

int mid
int start
int end
int max = 0;

for ( int[] interval: intervals){
    mid,start,end = 0;
    for  (int[] iteration : intervals) {
        start++
        if iteration[0] == interval[0] start ++
        else if iteration[1] == interval[0] end ++
        else if iteration[0] < interval[0] AND interval[0] > iteration[1] mid ++
    }
    max = Math.max(max, ( mid + math.max(sttart,end) ))
    mid,start,end = 0;
    for  (int[] iteration : intervals) {
        end++
        if iteration[0] == interval[1] start ++
        else if iteration[1] == interval[1] end ++
        else if iteration[0] < interval[1] AND interval[1] > iteration[1] mid ++
    }
    max = Math.max(max, ( mid + math.max(sttart,end) ))
}
}



*/
