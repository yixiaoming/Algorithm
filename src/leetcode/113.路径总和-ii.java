import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        process(root, sum, new LinkedList<>());
        return paths;
    }

    public void process(TreeNode root, int sum, LinkedList<Integer> path) {
        if(root == null) return;
        path.addLast(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            paths.add(new ArrayList<>(path));
        } else {
            process(root.left, sum - root.val, path);
            process(root.right, sum - root.val, path);
        }
        path.removeLast();
    }
}
// @lc code=end

