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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> init = new ArrayList<>();
        init.add(root);
        List<List<Integer>> ans = levelOrderH(init);
        ans.remove(ans.size()-1);
        return ans;
    }
    
    public List<List<Integer>> levelOrderH( List<TreeNode> input){
        //base cases
        List<List<Integer>> ans = new ArrayList<>();
        if (input.isEmpty()){
            return ans;
        }
        List<TreeNode> children = new ArrayList<>();
        List<Integer> thisLevel = new ArrayList<>();
        TreeNode cur;
        
        for (int i = 0; i< input.size(); i++){
            cur = input.get(i);
            if ( cur != null){
                thisLevel.add(cur.val);
                children.add(cur.left);
                children.add(cur.right);
            }
        }
        
        ans.add(thisLevel);
        ans.addAll(levelOrderH(children));
        return ans;
    }
}
