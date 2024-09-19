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
    public int kthSmallest(TreeNode root, int k) {
        int smallest = 0;
        TreeNode prev,cur;
        for (int i = 0; i < k; i++){
            prev = root;
            cur = root.left;
            if ( root.left == null){
                smallest = root.val;
                root = root.right;
            }else {
                while(cur.left != null){
                    prev = cur;
                    cur = cur.left;
                }
                smallest = cur.val;
                prev.left = cur.right;
            }
        }
        return smallest;
    }
}

/*
smallest = 0;
for ( int i = 0; i < k; i++)
    prev = root;
    cur = root.left;
    if (root.left == null) {
        smallest = root;
        root = root.right
    } else {
        while (cur.left != null)
            prev = cur;
            cur = cur.left;
        // we know cur is smallest;
        smallest = cur.value;
        prev.left = cur.right;
    }

 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list.get(k-1);
    }

    public void dfs(List<Integer> list, TreeNode node){
        if ( node == null) {return;}
        dfs(list,node.left);
        list.add(node.val);
        dfs(list,node.right);
    }
}
