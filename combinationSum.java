class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, list, answer);
        return answer;

    }

    public void combinationSumHelper(int[] candidates, int target, int pos, List<Integer> list, List<List<Integer>> answer){
        if (target == 0) { 
            answer.add(list);
            return;
        }
        if (pos >= candidates.length || target < 0) {return;}
        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        List<Integer> list3 = new ArrayList<>(list);
        //now we have two lists, one we skip, and one we take the element at pos
        //skip
        combinationSumHelper(candidates, target, pos+1, list1, answer);
        list2.add(candidates[pos]);
        list3.add(candidates[pos]);
        list3.add(candidates[pos]);
        //take1
        combinationSumHelper(candidates, target - candidates[pos], pos+1, list2, answer);
        //take2
        combinationSumHelper(candidates, target - 2*(candidates[pos]), pos, list3, answer);



    }
}
