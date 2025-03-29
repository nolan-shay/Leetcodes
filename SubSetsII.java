class Solution {
    List<List<Integer>> masterList;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        masterList = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> uniqueNums = new ArrayList<>();
        List<Integer> freq = new ArrayList<>();
        for (int num: nums){
            if (hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            } else {
                hm.put(num,1);
            }
        }
        for ( Map.Entry<Integer,Integer> e : hm.entrySet()){
            uniqueNums.add(e.getKey());
            freq.add(e.getValue());
        }

        recurse(uniqueNums, freq, 0, new ArrayList<>());
        return masterList;
    }

    public void recurse(List<Integer> nums,List<Integer> freq, int pos, List<Integer> subSet){
        if (pos == nums.size()){
            masterList.add(subSet);
            return;
        }
        //take
        recurse(nums,freq,pos+1, new ArrayList<>(subSet));
        for (int i = 0; i < freq.get(pos); i++){
            subSet.add(nums.get(pos));
            recurse(nums,freq,pos+1, new ArrayList<>(subSet));
        }
    }


}

/**

get a freqMap of nums
turn that into 
List<integer> nums ( unique)
List<Integer> freq
recursion(nums,freq,0, [])

recursion(list<int> nums, freq, pos, subSet){
    pos == nums.length{
        add subSet to masterLsit
        return
    }

    skip = recurse(pos+1)
    for(int i = 0; i < freq[pos]){
        subSet = copy of SubSet
        add nums[pos] to subset
    }
}

 */
