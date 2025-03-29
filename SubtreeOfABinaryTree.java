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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ( isSame(root,subRoot) ) return true;
        if (root == null) return false;
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame( TreeNode root1, TreeNode root2){
        if ( root1 == null && root2 == null){
            return true;
        } else if ( root1 == null || root2 == null){
            return false;
        } else if ( root1.val != root2.val){
            return false;
        } else {
            return isSame(root1.left,root2.left) && isSame(root1.right, root2.right);
        }
    }
}

/**

if ( isSame(root, subRoot) return true;
else return isSubtree(root.left, subRoot) || isSubtree(root.left, subRoot)

isSameTree( root1, root2){
    if root1 == null and root2 == null 
        return true
    else if root1 == null or root2 == null
        return false
    else if root.val != root2.val
        return false
    return isSameTree(roo1.left, root2.left) and isSameTree(roo1.right, root2.right)

}



**/
