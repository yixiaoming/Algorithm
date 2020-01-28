package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    double lastNum = -Double.MIN_VALUE;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        process(root);
        return result; 
    }

    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        result = result && (root.val > lastNum);
        lastNum = root.val;
        process(root.right);
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}