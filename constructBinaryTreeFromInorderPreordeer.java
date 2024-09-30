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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeHelper(preorder, inorder);
    }

    public TreeNode treeHelper(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if ( n==1) return root;
        int index = 0;
        while(inorder[index] != root.val) index++;
        if (index != 0){
            root.left = treeHelper(Arrays.copyOfRange(preorder, 1, 1+index), Arrays.copyOfRange(inorder,0,index));
        }
        if (index != n-1){
            root.right = treeHelper(Arrays.copyOfRange(preorder, 1+index, n), Arrays.copyOfRange(inorder,index+1,n));
        }
        return root;
    }
}
/*

[3,9,20,15,7], inorder = [9,3,15,20,7]

preorder[] inorder[]
root = new treeNode(preorder[start])
if size == one return root
index = index of that value in inorder. 
Then start - index = size of left subtree.
    if(index != 0)
        TreeNode.left = recurse( Arrays.copy(predorder,1, 1+index ) Arrays.copy(inorder, 0,index ))
    if ( index != n-1)
        TreeNode.right = recurse( Arrays.copy(predorder,1+index, n ) Arrays.copy(inorder,index+1, n ))
return root
    
if size == 1 create node, then return
size == 2


*/
