
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for ( int i : nums){
            if (hm.containsKey(i)){
                hm.put(i,hm.get(i) + 1);
            } else {
                hm.put(i,1);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] -b[1]);
        int counter = 0;
        for ( Map.Entry<Integer, Integer> el : hm.entrySet()){
            if ( counter < k){
                q.add(new int[]{el.getKey(), el.getValue()});
            }else{
                if (el.getValue() > q.peek()[1]){
                    q.poll();
                    q.add(new int[]{el.getKey(), el.getValue()});
                }
            }
            counter++;
        }
        int[] answer = new int[k];
        for ( int i = k-1; i >=0; i--){
            int[] smallest = q.poll();
            answer[i] = smallest[0];
        }
        return answer;
    }
}

/*

iterate over the list, making a freq map element:freq

iterate over the hashset and add all numbers to a priority queue 
*/
