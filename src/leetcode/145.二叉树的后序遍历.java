import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();

        stack.push(root);
        while(!stack.isEmpty() && root!=null){
            root = stack.pop();
            results.addFirst(root.val);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return results;
    }
}
// @lc code=end

