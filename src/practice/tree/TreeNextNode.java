package practice.tree;

/**
 * Created by Administrator on 19.10.13.
 * <p>
 * 找一个节点的后继节点
 * <p>
 * 每个节点中有一个指针指向parent
 * 一个节点的后继节点指中序遍历中，后一个节点。
 * <p>
 * 给定一颗树，求任意一个节点的后继节点。
 * 1. 按中序遍历打印，然后找到这个节点的后一个
 * 2. 如果这个节点有右孩子，则后继节点为有孩子的最左边的叶子节点
 * 如果这个节点无右孩子，则后继节点为当父节点为爷节点的左节点的时候
 */
public class TreeNextNode {

  /**
   *          1
   *       2     3
   *   4    5  6   7
   * 8
   * <p>
   * 4 2 8 5 1 6 3 7
   */
  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n5.left = n8;

    n2.parent = n1;
    n3.parent = n1;
    n4.parent = n2;
    n5.parent = n2;
    n6.parent = n3;
    n7.parent = n3;
    n8.parent = n5;

    TreeNode head = n8;
    if (getNextNode(head) != null) {
      System.out.println(getNextNode(head).value);
    } else {
      System.out.println("-1");
    }
  }

  public static TreeNode getNextNode(TreeNode head) {
    if (head == null) return null;
    if (head.right != null) {
      head = head.right;
      while (head.left != null) {
        head = head.left;
      }
      return head;
    } else {
      while (head.parent != null && head.parent.left != head) {
        head = head.parent;
      }
      return head.parent;
    }
  }
}
