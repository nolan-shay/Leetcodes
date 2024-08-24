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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low, high;
        if ( p.val < q.val){
            low = p.val;
            high = q.val;
        } else {
            high = p.val;
            low = q.val;
        }
        TreeNode cur = root;

        while(cur.val < low || cur.val > high ){
            if(high < cur.val){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        return cur;
        
    }
}
