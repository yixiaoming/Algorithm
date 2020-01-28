package practice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 19.10.14.
 * <p>
 * 序列化和反序列化树
 * 先序，中序，后序，按层
 */
public class SerializeTree {

  public static void main(String[] args) {
    /**
     *     1
     *   2   3
     * 4  5 6  7
     * @return
     */
    TreeNode head = TreeCreater.createRandomTree();
    // 1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_
    System.out.println(preOrderSerilaze(head));
    // #_4_#_2_#_5_#_1_#_6_#_3_#_7_#_
    System.out.println(inOrderSerialize(head));
    // #_#_4_#_#_5_2_#_#_6_#_#_7_3_1_
    System.out.println(postOrderSerialize(head));
    // 1_2_3_4_5_6_7_#_#_#_#_#_#_#_#_
    System.out.println(layerSerialize(head));

    head = preOrderDeSerialize("1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_");
    PrintTree.layerOrderPrint(head);

    head = layerDeSerialize("1_2_3_4_5_6_#_#_#_#_7_#_#_#_#_");
    PrintTree.layerOrderPrint(head);
  }

  public static String preOrderSerilaze(TreeNode node) {
    if (node == null) {
      return "#_";
    }
    String res = node.value + "_";
    res += preOrderSerilaze(node.left);
    res += preOrderSerilaze(node.right);
    return res;
  }

  public static String inOrderSerialize(TreeNode node) {
    if (node == null) {
      return "#_";
    }
    String res = inOrderSerialize(node.left);
    res += node.value + "_";
    res += inOrderSerialize(node.right);
    return res;
  }

  public static String postOrderSerialize(TreeNode node) {
    if (node == null) {
      return "#_";
    }
    String res = postOrderSerialize(node.left);
    res += postOrderSerialize(node.right);
    res += node.value + "_";
    return res;
  }

  public static String layerSerialize(TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    StringBuilder res = new StringBuilder();
    while (!queue.isEmpty()) {
      node = queue.poll();
      if (node != null) {
        res.append(node.value).append("_");
        queue.add(node.left);
        queue.add(node.right);
      } else {
        res.append("#_");
      }
    }
    return res.toString();
  }

  // 如果把null算上，一定是一个完全二叉树，可以用数组的形式算出父节点和孩子的位置
  public static TreeNode layerDeSerialize(String strs) {
    String[] items = strs.split("_");
    TreeNode[] tree = new TreeNode[items.length];
    for (int i = 0; i < tree.length; i++) {
      if ("#".equals(items[i])) {
        tree[i] = null;
      } else {
        TreeNode node = new TreeNode(Integer.valueOf(items[i]));
        tree[i] = node;
        int parentIndex = (i - 1) / 2;
        if (parentIndex >= 0 && parentIndex * 2 + 1 == i) {
          tree[parentIndex].left = tree[i];
        }
        if (parentIndex >= 0 && parentIndex * 2 + 2 == i) {
          tree[parentIndex].right = tree[i];
        }
      }
    }
    return tree[0];
  }

  /**
   * "1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_"
   */
  public static TreeNode preOrderDeSerialize(String str) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(str.split("_")));
    return preOrderDeSerialize(queue);
  }

  private static TreeNode preOrderDeSerialize(Queue<String> strs) {
    String value = strs.poll();
    if ("#".equals(value)) {
      return null;
    }
    TreeNode head = new TreeNode(Integer.valueOf(value));
    head.left = preOrderDeSerialize(strs);
    head.right = preOrderDeSerialize(strs);
    return head;
  }
}