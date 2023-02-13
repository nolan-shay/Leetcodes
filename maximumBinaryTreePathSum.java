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
    public int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int pivot = longestPathPivot(root);
        int childMax = Math.max( maxPathSum(root.left), maxPathSum(root.right));
        return Math.max(childMax,pivot);
    }

    private int longestPathContaining(TreeNode root){
        if ( root == null) return Integer.MIN_VALUE;
        int left = longestPathContaining(root.left);
        int right = longestPathContaining(root.right);
        if ( left <= 0 && right <= 0) return root.val;
        else return root.val + Math.max(left,right);

    }

    private int longestPathPivot(TreeNode root){
        if ( root == null) return Integer.MIN_VALUE;
        int left = longestPathContaining(root.left);
        int right = longestPathContaining(root.right);
        if ( left < 0) left = 0;
        if ( right < 0) right = 0;
        return root.val + left + right;
    }
}
