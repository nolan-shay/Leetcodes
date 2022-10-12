/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymH(root.left, root.right);
        
    }
    
    public boolean isSymH(TreeNode node1, TreeNode node2){
        //base cases
        if (node1 == null || node2 == null){
            return (node1 == null && node2 == null);
        }
        
        if (node1.val == node2.val){
            return isSymH(node1.left, node2.right) && isSymH(node1.right, node2.left);
        }
        return false;
        
    }
}
