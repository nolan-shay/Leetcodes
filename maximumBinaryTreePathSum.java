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
class Solution3 {
    public int maxPathSum(TreeNode root) {
        int[] answer = new int[]{root.val};
        calculateOneWayPaths(root, answer);
        return(answer[0]);
    }

    private int calculateOneWayPaths(TreeNode root, int[] answer){
        if ( root == null) return Integer.MIN_VALUE;
        int left, right;
        left = calculateOneWayPaths(root.left, answer);
        right = calculateOneWayPaths(root.right, answer);
        int thisMax = root.val;
        if ( left > 0) thisMax += left;
        if ( right > 0) thisMax += right;
        if (thisMax > answer[0]) answer[0] = thisMax;
        
        if ( left <= 0 && right <= 0) return root.val;
        else return root.val + Math.max(left,right);

    }

}






class Solution1 {
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





class Solution2 {
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        calculateOneWayPaths(root, hm);
        return findMaxPath(root, hm);
    }

    private int calculateOneWayPaths(TreeNode root, HashMap<TreeNode,Integer> hm){
        if ( root == null) return Integer.MIN_VALUE;
        int left, right;

        if (hm.containsKey(root.left) ) left = hm.get(root.left);
        else left = calculateOneWayPaths(root.left, hm);

        if (hm.containsKey(root.right) ) right = hm.get(root.right);
        else right = calculateOneWayPaths(root.right, hm);

        if ( left <= 0 && right <= 0){
            hm.put(root,root.val);
            return root.val;
        } else {
            hm.put(root, root.val + Math.max(left,right));
            return root.val + Math.max(left,right);
        }

    }

    private int findMaxPath(TreeNode root, HashMap<TreeNode,Integer> hm){
        if ( root == null) return Integer.MIN_VALUE;
        int left, right;
        if ( root.left == null || hm.get(root.left) < 0 ) left = 0;
        else left = hm.get(root.left);
        if ( root.right == null || hm.get(root.right) < 0 ) right = 0;
        else right = hm.get(root.right);
        int thisMax = root.val + left + right;
        int childMax = Math.max(findMaxPath(root.left, hm), findMaxPath(root.right, hm));
        return Math.max(thisMax, childMax);

    }
}
