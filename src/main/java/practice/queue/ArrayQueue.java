package practice.queue;

/**
 * Created by Administrator on 19.10.9.
 * 1. 用数组实现一个队列
 * 2. 用队列结构实现栈
 */
public class ArrayQueue {

  public static void main(String[] args) {
    testTwoStackQueue();
  }

  public void testArrayQueue() {
    Queue queue = new Queue(10);
    for (int i = 1; i <= 10; i++) {
      queue.put(i);
      queue.printContent();
    }
    for (int i = 1; i <= 5; i++) {
      System.out.println(queue.pop());
    }
    for (int i = 1; i <= 5; i++) {
      queue.put(10 + i);
      queue.printContent();
    }
    while (!queue.isEmpty()) {
      System.out.println(queue.pop());
    }
  }

  public static void testTwoStackQueue() {
    TwoStackQueue queue = new TwoStackQueue(10);
    for (int i=1; i<=10 ;i++) {
      queue.put(i);
    }
    for (int i = 1; i <= 5; i++) {
      System.out.println(queue.pop());
    }
    for (int i = 1; i <= 5; i++) {
      queue.put(10 + i);
    }
    while (!queue.isEmpty()) {
      System.out.println(queue.pop());
    }
  }
}
