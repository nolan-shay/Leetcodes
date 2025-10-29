class Solution {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root,1);
        return ans;
    }

    public void dfs(TreeNode root, int level){
        if ( root == null) return;
        if ( level > ans.size()) ans.add(root.val);
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
