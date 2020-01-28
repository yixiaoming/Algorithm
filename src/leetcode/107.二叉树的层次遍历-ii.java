package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int level = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
                level++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                level++;
            }
            if (--count == 0) {
                count = level;
                level = 0;
                results.add(0, result);
                result = new ArrayList<>();
            }
        }
        return results;
    }
}
// @lc code=end

