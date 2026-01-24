/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return dfs(root, root->val);
    }

    int dfs(TreeNode* root, int localMax){
        if (root == nullptr) return 0;
        int total = 0;
        int newMax = localMax;
        if (root->val >= localMax){
            total = 1;
            newMax = root->val;
        }
        total += dfs(root->right, newMax);
        total += dfs(root->left, newMax);
        return total;
    }
};

/*

so we do a dfs and we keep track of path maximum

val = *root

*/
