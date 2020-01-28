package practice.stack;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.11.
 * 栈
 */
public class Stack {
  private int[] arr;
  private int top;

  public Stack(int size) {
    arr = new int[size];
  }

  public void put(int value) {
    if (isFull()) {
      throw new RuntimeException("practice.stack.Stack is full");
    }
    arr[top++] = value;
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty");
    }
    return arr[top - 1];
  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty");
    }
    return arr[--top];
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public boolean isFull() {
    return top == arr.length;
  }

  public void printContent() {
    System.out.println(Arrays.toString(arr));
  }
}