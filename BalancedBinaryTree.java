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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(left == -1 || right == -1) return false;
        return Math.abs(left-right) <= 1;
    }

    public int isBalancedHelper( TreeNode root){
        if (root == null) return 0;
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left-right) <= 1) return 1 + Math.max(left,right);
        return -1;
    }
}
/**

boolean isBalanced(TreeNode root)
if root == null return true
int left = isBalancedH(root.left)
int roght = isBalancedH(root.right)
if left or right == -1 return false
else return true if |left - right| <= 1



integer isBalancedH (TreeNode root)
    if root == null return 0;
    int left = isBalancedH(root.left)
    int roght = isBalancedH(root.right)
    if left or right == -1 return -1;
    if (abs(left- right) <= 1) return 1 + max(left,right);

 */
