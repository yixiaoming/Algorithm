import java.util.Arrays;


/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int pos = 0;
        while (inorder[pos] != val)
            pos++;

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos+1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos+1, preorder.length),Arrays.copyOfRange(inorder, pos+1, inorder.length));
        return root;
    }
}
// @lc code=end
