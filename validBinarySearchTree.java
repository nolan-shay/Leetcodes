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
    public boolean isValidBST(TreeNode root) {
        return leftMove(root.left, root.val, 0, false) && rightMove(root.right, 0, root.val, false);
    }

    public boolean leftMove( TreeNode root, int max, int min, boolean minSet){
        if ( root == null) return true;
        //check if value is valid
        if ( root.val >= max) return false;
        if (minSet && root.val <= min) return false;
        return leftMove(root.left, root.val , min, minSet) && rightMove(root.right, max, root.val, true);
    }

    public boolean rightMove( TreeNode root, int max, int min, boolean maxSet){
        if ( root == null) return true;
        // check if value is valid
        if (root.val <= min) return false;
        if (maxSet && root. val >= max) return false;
        return leftMove(root.left, root.val, min, true) && rightMove(root.right, max, root.val, maxSet);
    }
}
