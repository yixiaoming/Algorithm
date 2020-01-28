package practice.queue;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.11.
 * 队列
 */
public class Queue {
  private int[] queue;
  private int head;
  private int tail;
  private int length;

  public Queue(int size) {
    queue = new int[size];
  }

  public void put(int value) {
    if (length == queue.length) {
      throw new RuntimeException("practice.queue.Queue is full!");
    }
    tail = tail == queue.length ? 0 : tail;
    length++;
    queue[tail++] = value;
  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("practice.queue.Queue is empty!");
    }
    head = head == queue.length ? 0 : head;
    length--;
    return queue[head++];
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("practice.queue.Queue is empty!");
    }
    return queue[head];
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return length == queue.length;
  }

  public int size() {
    return length;
  }

  public void printContent() {
    System.out.println(Arrays.toString(queue) + " head:" + head + " tail:" + tail+" len:"+length);
  }
}