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
        if ( isSameTree(root,subRoot)) return true;
        if ( root == null) return false;
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode root2) {
        if ( root == null && root2 == null) return true;
        if ( root == null || root2 == null) return false;
        if ( root.val != root2.val) return false;
        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
    }
}


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //serialize root and subRoot
        String haystack = serialize(root);
        String needle = serialize(subRoot);
        // then we have the classic problem of does string needle exist in string haystack;
        return haystack.indexOf(needle) != -1 ;
    }

    public String serialize( TreeNode root){
        //preorder traversal
        if (root == null) return "#";
        StringBuilder answer = new StringBuilder(" " + root.val);
        answer.append(serialize(root.left) );
        answer.append(serialize(root.right) );
        return answer.toString();
    }

}
