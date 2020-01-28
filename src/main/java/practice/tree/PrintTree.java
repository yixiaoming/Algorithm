package practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 19.10.13.
 */
public class PrintTree {

  public static void main(String[] args) {

    /**
     *       1
     *   2       3
     *    4     6
     *   7 5
     */
    TreeNode head = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    head.left = n2;
    head.right = n3;
    n2.right = n4;
    n4.right = n5;
    n4.left = n7;
    n3.left = n6;

    preOrderPrint(head);
    System.out.println();
    preOrderPrint2(head);
    System.out.println();

    inOrderPrint(head);
    System.out.println();
    inOrderPrint2(head);
    System.out.println();

    postOrderPrint(head);
    System.out.println();
    postOrderPrint2(head);
    System.out.println();

    layerOrderPrint(head);
    System.out.println();

  }

  public static void preOrderPrint(TreeNode head) {
    if (head == null) return;
    System.out.printf("%d,", head.value);
    preOrderPrint(head.left);
    preOrderPrint(head.right);
  }

  public static void inOrderPrint(TreeNode head) {
    if (head == null) return;
    inOrderPrint(head.left);
    System.out.printf("%d,", head.value);
    inOrderPrint(head.right);
  }

  public static void postOrderPrint(TreeNode head) {
    if (head == null) return;
    postOrderPrint(head.left);
    postOrderPrint(head.right);
    System.out.printf("%d,", head.value);
  }

  public static void preOrderPrint2(TreeNode head) {
    if (head == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(head);
    while (!stack.isEmpty()) {
      head = stack.pop();
      System.out.printf("%d,", head.value);
      if (head.right != null) {
        stack.push(head.right);
      }
      if (head.left != null) {
        stack.push(head.left);
      }
    }
  }

  public static void inOrderPrint2(TreeNode head) {
    if (head == null) return;
    Stack<TreeNode> stack = new Stack<>();
    while (head != null || !stack.isEmpty()) {
      if (head != null) {
        stack.push(head);
        head = head.left;
      } else {
        head = stack.pop();
        System.out.printf("%d,", head.value);
        head = head.right;
      }
    }
  }

  public static void postOrderPrint2(TreeNode head) {
    if (head == null) return;
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    stack1.push(head);
    while (!stack1.isEmpty()) {
      head = stack1.pop();
      stack2.push(head);
      if (head.left != null) {
        stack1.push(head.left);
      }
      if (head.right != null) {
        stack1.push(head.right);
      }
    }
    while (!stack2.isEmpty()) {
      head = stack2.pop();
      System.out.printf("%d,", head.value);
    }
  }

  public static void layerOrderPrint(TreeNode head) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(head);
    int cur = 1;
    int next = 0;
    while (!queue.isEmpty()) {
      head = queue.poll();
      cur--;
      System.out.printf("%d,", head.value);
      if (head.left != null) {
        queue.add(head.left);
        next++;
      }
      if (head.right != null) {
        queue.add(head.right);
        next++;
      }
      if (cur == 0) {
        System.out.println();
        cur = next;
        next = 0;
      }
    }
  }
}
