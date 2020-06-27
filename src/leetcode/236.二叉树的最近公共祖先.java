import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode lson = lowestCommonAncestor(root.left, p, q);
        TreeNode rson = lowestCommonAncestor(root.right, p, q);
        if ((p == root || q == root) || (lson != null && rson != null)) {
            return root;
        }
        if (lson != null) {
            return lson;
        }
        if (rson != null) {
            return rson;
        }
        return null;
    }
}
// @lc code=end
