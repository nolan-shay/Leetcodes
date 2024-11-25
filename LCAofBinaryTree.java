/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return lca;
        
    }

    public boolean dfs( TreeNode node, int p, int q){
        if ( node == null) return false;
        boolean left = dfs( node.left,p,q);
        boolean right = dfs( node.right,p,q);
        if (left && right){
            if ( lca == null){
                lca = node;
            }
            return true;
        } else if( (node.val ==p || node.val ==q) && (left || right) ) {
            if ( lca == null){
                lca = node;
            }
            return true;
        } else if (node.val ==p || node.val ==q || left || right ){
            return true;
        }
        return false;

    }

}

/*
dfs(root)
int LCA = 0;
boolean set = false;

boolean dfs(TreeNode node, p.val, q.val){
    if node == null return false;
    boolean left = dfs(node.left)
    boolean right = dfs(node.right)
    if (left and right) 
        // this means node is an ancestor of p and q
        // and the first time we see this we have found LCA
        if ( !set)
            LCA = node
        return true;
    else if ((node.val = p or node.val = q) AND ( left or right) 
        // this means node is an ancestor of p and q
        // and the first time we see this we have found LCA
        if ( !set)
            LCA = node
        return true;
    else if node.val = p or node.val = q or left or right
        return true;
    return false;
}


*/
