package practice.stack;

import practice.queue.Queue;

/**
 * Created by Administrator on 19.10.11.
 * 用两个Queue实现一个栈
 */
public class TwoQueueStack {

  private Queue inputQueue;
  private Queue outputQueue;

  public TwoQueueStack(int size) {
    inputQueue = new Queue(size);
    outputQueue = new Queue(size);
  }

  public void put(int value) {
    if (inputQueue.isFull()) {
      throw new RuntimeException("practice.stack.Stack is full!");
    }
    inputQueue.put(value);
  }

  public int pop() {
    if (inputQueue.isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty!");
    }
    while (inputQueue.size() != 1) {
      outputQueue.put(inputQueue.pop());
    }
    int result = inputQueue.pop();

    Queue temp = inputQueue;
    inputQueue = outputQueue;
    outputQueue = temp;

    return result;
  }

  public int peek() {
    if (inputQueue.isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty!");
    }
    while (inputQueue.size() != 1) {
      outputQueue.put(inputQueue.pop());
    }
    return inputQueue.peek();
  }

  public boolean isEmpty() {
    return inputQueue.isEmpty();
  }

  public void printContent() {
    inputQueue.printContent();
    outputQueue.printContent();
  }
}
