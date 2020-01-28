package practice.list;

/**
 * Created by Administrator on 19.10.12.
 */
public class LinkedList {

  public static void main(String[] args) {
    LinkedList l = new LinkedList();
    for (int i = 1; i <= 10; i++) {
      l.add(new ListNode(i));
    }
    l.printContent();
    l.reverse();
    l.printContent();
    l.remove(10);
    l.printContent();
  }

  private ListNode head;

  public void add(ListNode node) {
    if (head == null) {
      head = node;
    } else {
      ListNode cur = head;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = node;
    }
  }

  public void remove(int value) {
    if (head == null) {
      return;
    }
    if (head.value == value) {
      head = head.next;
      return;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (cur.value == value) {
        pre.next = cur.next;
      }
      pre = pre.next;
      cur = cur.next;
    }
  }

  public void reverse() {
    if (head == null || head.next == null) {
      return;
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
    head = pre;
  }

  public void printContent() {
    ListNode cur = head;
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (cur != null) {
      sb.append(cur.value).append(cur.next == null ? "" : ",");
      cur = cur.next;
    }
    sb.append("]");
    System.out.println(sb);
  }
}
