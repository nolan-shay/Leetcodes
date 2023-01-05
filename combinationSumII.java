class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
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

        //skip
        int skipPos = pos+1;
        while(skipPos < candidates.length && candidates[skipPos] == candidates[pos]){
            skipPos++;
        }
        combinationSumHelper(candidates, target, skipPos, list1, answer);
        list2.add(candidates[pos]);
        //take
        combinationSumHelper(candidates, target - candidates[pos], pos+1, list2, answer);


    }
}
