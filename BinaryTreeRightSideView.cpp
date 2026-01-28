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
    vector<int> rightSideView(TreeNode* root) {
        std::vector<int> ans;
        dfs(ans, root, 1);
        return ans;
    }

    void dfs(vector<int>& ans, TreeNode* root, int level){
        if (root == nullptr) return;
        if (level > ans.size()){
            ans.push_back(root->val);
        }
        dfs(ans,root->right, level+1);
        dfs(ans,root->left, level+1);
    }
};

/*

plan is do dfs but visit right first always, and then keep track of your level, then keep a list and check if the list is the size of your level, if it is keep going, else add your val to the list

*/
