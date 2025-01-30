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

class SolutionJan2025 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if (cur.node != null){
                if (ans.size() <= cur.level){
                    ans.add(new ArrayList<>());
                }
                ans.get(cur.level).add(cur.node.val);
                q.add(new Pair(cur.node.left,cur.level+1));
                q.add(new Pair(cur.node.right,cur.level+1));
            }
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int level;

    public Pair (TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
