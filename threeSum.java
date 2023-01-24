class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> distinct = new ArrayList<>();
        for (int x : nums){
            if ( hm.containsKey(x)){
                hm.put(x,hm.get(x)+1);
            } else {
                distinct.add( x);
                hm.put( x,1);
            }
        }
        Collections.sort(distinct);
        if ( hm.containsKey(0) && hm.get(0) > 2){ answer.add(Arrays.asList(0,0,0));}

        for ( int i = 0; i < distinct.size() && distinct.get(i) < 0; i++){
            for (int j = i+1; j < distinct.size(); j++){
                int desired = -(distinct.get(i) + distinct.get(j));
                if ( desired >= distinct.get(j) || desired == distinct.get(i)){
                    if ( hm.containsKey(desired)){
                        if ( desired == distinct.get(i) || desired == distinct.get(j)){
                            if ( hm.get(desired) > 1){
                                answer.add(Arrays.asList( distinct.get(i), distinct.get(j), desired));
                            } 
                        } else {
                            answer.add(Arrays.asList(distinct.get(i), distinct.get(j), desired));
                        }
                    }
                }
            }
        }

        return answer;

        
    }
