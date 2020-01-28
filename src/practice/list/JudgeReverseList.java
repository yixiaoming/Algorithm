package practice.list;

import java.util.Stack;

/**
 * Created by Administrator on 19.10.10.
 * 判断一个链表是否是回文链表
 * <p>
 * 1. 用一个辅助栈，第一次遍历一次压栈，第二次遍历同时出栈，判断每个节点是否相等
 * 2. 一个快指针一个慢指针，一个步长1一个步长2。当走到中点之后将后半链表反转。然后依次从两头向中间访问，所有节点需要相同
 */
public class JudgeReverseList {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n4 = new ListNode(2);
    ListNode n5 = new ListNode(1);
    n1.next = n2;
    n2.next = n4;
    n4.next = n5;
    System.out.println(judgeReverseList2(n5));
  }

  public static boolean judgeReverseList(ListNode node) {
    if (node == null || node.next == null) {
      return true;
    }
    Stack<ListNode> stack = new Stack<>();
    ListNode cur = node;
    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    cur = node;
    ListNode top;
    while (cur != null) {
      top = stack.pop();
      if (top.value != cur.value) {
        return false;
      }
      cur = cur.next;
    }
    return true;
  }

  public static boolean judgeReverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next.next == null ? fast.next : fast.next.next;
    }
    ListNode halfHead = slow.next;
    halfHead = reverseList(halfHead);

    ListNode p1 = head;
    ListNode p2 = halfHead;
    while (p2 != null) {
      if (p2.value != p1.value) {
        return false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }
    return true;
  }

  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;
    ListNode next;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
