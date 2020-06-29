import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int cur = pathcount(root, sum);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return cur + left + right;
    }

    public int pathcount(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        int result = sum == 0 ? 1:0;
        return result + pathcount(root.left, sum) + pathcount(root.right, sum);
    }
}
// @lc code=end

