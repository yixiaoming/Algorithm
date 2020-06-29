import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import sun.nio.ch.SelChImpl;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return String.valueOf(root.val)+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> items = new LinkedList(Arrays.asList(data.split(",")));
        System.out.println(data);
        return process(items);
    }

    private TreeNode process(List<String> items){
        String item = items.get(0);
        if(item.equalsIgnoreCase("#")) {
            items.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(item));
        items.remove(0);
        root.left = process(items);
        root.right = process(items);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

