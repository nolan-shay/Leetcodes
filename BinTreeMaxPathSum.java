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
    // HashMap<TreeNode, Integer> rMaxes;
    HashMap<TreeNode, Integer> sMaxes;
    int globalMax;
    public int maxPathSum(TreeNode root) {
        // rMaxes = new HashMap<>();
        sMaxes = new HashMap<>();
        globalMax = root.val;

        dfs(root);

        return globalMax;
        
    }

    public void dfs(TreeNode node){
        if (node != null){
            dfs(node.left);
            dfs(node.right);
            int leftSMax = node.left != null ? sMaxes.get(node.left) : 0;
            int rightSMax = node.right != null ? sMaxes.get(node.right) : 0;
            int sMax = Math.max(leftSMax,rightSMax) + node.val;
            sMax = Math.max(sMax,node.val);
            int rMax = leftSMax + rightSMax + node.val;
            sMaxes.put(node,sMax);
            globalMax = Math.max(globalMax,sMax);
            globalMax = Math.max(globalMax,rMax);
        }
    }
}

/**

dfs( Node )

if Node != null
    dfs(left)
    dfs(right)
    leftSMax = node.left != null ? node.left.Smax
    rightSMax = node.right != null ? node.right.Smax
    Node.Smax = Math.max(leftSmax,rightSmax) + Node.val:
    Node.Rmax = leftSmax, rightSmax + Node.val
    global max = max(globalMax,node.Smax, node.Rmax);


 */
