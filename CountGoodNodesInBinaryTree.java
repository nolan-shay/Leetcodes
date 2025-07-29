class Solution { // 7/28/2025
    int goodCount;
    public int goodNodes(TreeNode root) {
        goodCount = 0;
        dfs(root, -10001);
        return goodCount;
    }

    public void dfs (TreeNode node, int localMax){
        if ( node == null) return;
        if (node.val >= localMax){
            goodCount++;
            localMax = node.val;
        }
        dfs(node.left, loacalMax);
        dfs(node.right, localMax);
    }
}

/*
call dfs on root

dfs( TreeNode node , int localMax)
    if node null return;
    if node.value >= localMax
        goodNodes ++;
        localMax = node.value
    dfs(node.left, localMax)
    dfs(node.right, localMax)


*/
