class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        answer.add(empty);
        List<List<Integer>> additionalLists = new ArrayList<>();

        for ( int i : nums){ 
            for ( List l : answer){ 
                List<Integer> copy = new ArrayList<>(l); //this operation happens 2^n times and its n
                copy.add(i);
                additionalLists.add(copy);
            }
            answer.addAll(additionalLists);
            additionalLists = new ArrayList<>();
        }
        return answer;

        
    }
}
/*
//answer = { [] }
// additionalLists = new ArrayList<>();

for ( int i : nums){
    for ( list l : ans){
        newList = copy of l;
        newList.add(i);
        additionalLists.add(newList)
    }
    answer.addAll(additionalLists);
    additionalLists = new ArrayList<>();
}


return answer;

*/

class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> empty = new ArrayList<>();
        helper(empty,0,nums);
        return subsets;
    }

    public void helper( List<Integer> subset, int pos, int[] nums){
        if (pos == nums.length){
            subsets.add(subset);
            return;
        }
        List<Integer> copy = new ArrayList<>(subset);
        helper(copy,pos+1,nums);
        subset.add(nums[pos]);
        helper(subset,pos+1,nums);
    }
        
}
