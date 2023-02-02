class Solution {
    public int[][] merge(int[][] intervals) {
        //check for length 1, return intervals
        if ( intervals.length == 1) return intervals;
        Arrays.sort(intervals, new InterValOrder()); // sort based on intervals[i][0]
        HashSet<int[]> hs1 = new HashSet<>();
        // add first interval to set holdon to refernce of that set, iterate over the rest starting at pos 1
        hs1.add(intervals[0]);
        int[] lastInterval = intervals[0];
        // if current overlaps reference, update reference
        for ( int[] interval : intervals){
            if ( interval[0] <= lastInterval[1]){ // we have overlap
                lastInterval[1] = Math.max(interval[1],lastInterval[1]);
            } else { // else add current and make current the reference
                hs1.add(interval);
                lastInterval = interval;
            }
        }
        //loop through hashset and add to an array
        int[][] answer = new int[hs1.size()][2];
        int i = 0;
        for (int[] el : hs1){
            answer[i] = el;
            i++;
        }

        return answer;
    }
}

//create a comparator class for these intervals
class InterValOrder implements Comparator<int[]>{

    public int compare(int[] interval1, int[] interval2){
        return interval1[0] - interval2[0];
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        HashMap<Integer, int[]> hm1 = new HashMap<>();
        HashSet<int[]> intervalSet = new HashSet<>();
        for ( int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!hm1.containsKey(start) && !hm1.containsKey(end)){
                for ( int j = start; j <= end; j++){
                    hm1.put(j,intervals[i]);
                }
            } else if ( !hm1.containsKey(end) ){ // start is within the bounds of an existing interval
                for ( int j = hm1.get(start)[1]; j <= end; j++ ){
                    hm1.put(j, hm1.get(start));
                }
                hm1.get(start)[1] = end;
            } else if ( !hm1.containsKey(start) ){ // start is within the bounds of an existing interval
                for ( int j = start; j <= hm1.get(end)[0]; j++ ){
                    hm1.put(j, hm1.get(end));
                }
                hm1.get(end)[0] = start;
                // this point and below, both end and start are contained in the array, 
                //but we do nothing if they are completely enveloped by a larger interval
            } else if ( hm1.get(start) != hm1.get(end) ){ //here we need to merge two sets already in our hm1
                int firstEnd = hm1.get(start)[1];
                hm1.get(start)[1] = hm1.get(end)[1];
                for ( int j = firstEnd; j<= hm1.get(end)[1]; j++){
                    hm1.put(j, hm1.get(start));
                }
            }
        }
        for ( Map.Entry<Integer,int[]> el : hm1.entrySet()){
            intervalSet.add(el.getValue());
        }
        int[][] answer = new int[intervalSet.size()][2];
        int i = 0;
        for (int[] el : intervalSet){
            answer[i] = el;
            i++;
        }
        return answer;
    }
}
