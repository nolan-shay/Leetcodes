class TimeMap { //7/27/25
    HashMap<String, List<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)){ hm.put(key, new ArrayList<>());}
        hm.get(key).add(new Pair(timestamp, value));
    }
    /*
        hm.get(key).add(timestamp,value)
    */
    
    public String get(String key, int timestamp) {
        if ( !hm.containsKey(key)) return "";
        List<Pair> list = hm.get(key);
        if (list.isEmpty() || timestamp < list.get(0).timeStamp) return "";
        //else bin search
        int start = 0, end = list.size()-1, mid = start+ (end-start)/2;
        while( start < end -1 ){
            if ( list.get(mid).timeStamp <= timestamp){
                start = mid;
            } else { end = mid-1;}
            mid = start + (end-start)/2;
        }
        return list.get(end).timeStamp <= timestamp ? list.get(end).value : list.get(start).value;
        
    }
    /*
        list<Pair> list = hm.get(key);
        if list is empty
        or check if key is before its first element return ""
        else do bin search to find the last element <= key;

    */
}

class Pair{
    int timeStamp;
    String value;
    public Pair( int timeStamp, String value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);

 we can have a hashmap<String,List<Pair>>

 Pair {
    int timeStamp
    String value
 }


 */
