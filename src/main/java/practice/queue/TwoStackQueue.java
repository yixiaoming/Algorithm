package practice.queue;


import practice.stack.Stack;

/**
 * Created by Administrator on 19.10.11.
 * 用两个stack实现一个queue
 */
public class TwoStackQueue {

  private Stack inputStack;
  private Stack outputStack;

  public TwoStackQueue(int size) {
    inputStack = new Stack(size);
    outputStack = new Stack(size);
  }

  public void put(int value) {
    if (inputStack.isFull()) {
      throw new RuntimeException("practice.queue.Queue is full!");
    }
    inputStack.put(value);
  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("practice.queue.Queue is empty!");
    }
    if (outputStack.isEmpty()) {
      while (!inputStack.isEmpty()) {
        outputStack.put(inputStack.pop());
      }
    }
    return outputStack.pop();
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("practice.queue.Queue is empty!");
    }
    if (outputStack.isEmpty()) {
      while (!inputStack.isEmpty()) {
        outputStack.put(inputStack.pop());
      }
    }
    return outputStack.peek();
  }

  public boolean isEmpty() {
    return outputStack.isEmpty() && inputStack.isEmpty();
  }
}
