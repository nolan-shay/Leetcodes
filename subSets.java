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
