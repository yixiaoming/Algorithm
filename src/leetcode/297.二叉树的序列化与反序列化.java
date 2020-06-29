import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
        if(root == null) return "#,";
        return ""+root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> items = new LinkedList(Arrays.asList(data.split(",")));
        System.out.println(data);
        return dfs(items);
    }

    public TreeNode dfs(List<String> items){
        String item = items.get(0);
        if(item.equals("#")) {
            items.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(item));
        items.remove(0);
        root.left = dfs(items);
        root.right = dfs(items);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

