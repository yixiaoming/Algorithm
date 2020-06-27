import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if(root == null) return result;
        process(root, "", result);
        return result;
    }

    public void process(TreeNode root, String cur, List<String> result){
        if(root == null){
            return;
        }
        if(cur.length() == 0){
            cur = cur+root.val;
        } else{
            cur = cur+"->"+root.val;
        }
        if(root.left == null && root.right == null){
            result.add(cur);
            return;
        }
        process(root.left, cur, result);
        process(root.right, cur, result);
    }
}
// @lc code=end

