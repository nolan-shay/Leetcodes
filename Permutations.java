class Solution {
    int numVisited;
    boolean visited[];
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        visited = new boolean[nums.length];
        numVisited = 0;
        helper(nums, new ArrayList<>());
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> curList){
        if (numVisited == nums.length){
            ans.add(curList);
            return;
        }
        for( int i = 0; i < nums.length; i++){
            if (!visited[i]){
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(nums[i]);
                visited[i] = true;
                numVisited++;
                helper(nums,newList);
                visited[i] = false;
                numVisited--;
            }
        }
    }
}

/**

helper( nums, curList)

    if num visited == nums.length
        add curlist to ans;
    for i in nums
        if unvisited
            newList = curList+nums[i]
            visited[i] true;
            numVisited++;
            helper(nums, newList);
            visited[i] = false;
            numVisited--;

        

 */
