class SolutionImproved {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs = new HashSet<>();
        int mid, right, sum;
        Arrays.sort(nums);
        for (int left = 0; left <= nums.length -3; left++){
            mid = left+1;
            right = nums.length-1;
            while ( mid < right){
                sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0){
                    //System.out.println("adding " +  nums[left] + " " + nums[mid] + " " + nums[right]);
                    hs.add( Arrays.asList(nums[left],nums[mid],nums[right]));
                    mid++;
                    right--;
                } else if ( sum < 0){
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(hs);



        
    }
    /*
    use a Set to store our triplets, and ensure the triplets are only added in numerical order. 
    use a two pointer method

    for i = 1 to 3rd to last number
        mid = i +1;
        right = last;
        while mid < right
            caclulate sum
            if sum = 0, add to set
            if sum < 0 mid ++
            if sum > 0 mid --

    

    */

class SolutionFirst {
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
