package practice.stack;

/**
 * Created by Administrator on 19.10.9.
 * 1. 用数组实现一个栈
 * 2. 用栈结构实现队列
 * 3. 给栈增加一个getMin返回栈中最小值，时间复杂度O(1)
 */
public class ArrayStack {

  public static void main(String[] args) {
    testMinStack();
  }

  public static void testArrayStack() {
    Stack stack = new Stack(10);
    for (int i = 1; i <= 10; i++) {
      stack.put(i);
      stack.printContent();
    }
    for (int i = 1; i <= 5; i++) {
      System.out.println(stack.pop());
    }
    for (int i = 1; i <= 5; i++) {
      stack.put(10 + i);
      stack.printContent();
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  public static void testTwoQueueStack() {
    TwoQueueStack stack = new TwoQueueStack(10);
    for (int i = 1; i <= 10; i++) {
      stack.put(i);
    }
    for (int i = 1; i <= 5; i++) {
      System.out.println(stack.pop());
      stack.printContent();
    }
    for (int i = 1; i <= 3; i++) {
      stack.put(10 + i);
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  public static void testMinStack() {
    MinArrayStack stack = new MinArrayStack(10);
    stack.put(5);
    for (int i = 1; i <= 9; i++) {
      stack.put(i);
      stack.printContent();
    }
    System.out.println(stack.peek());
    System.out.println(stack.getMin());
    while (!stack.isEmpty()) {
      System.out.println(stack.getMin() + "," + stack.pop());
    }
  }
}
