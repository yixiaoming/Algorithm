package practice.stack;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.9.
 * 数组实现一个栈，除了push和pop方法外，还需要getMin方法返回栈中最小的数，时间复杂度为O(1)
 */
public class MinArrayStack {

  private int[] arr;
  private int[] minArr;
  private int top;

  public MinArrayStack(int size) {
    arr = new int[size];
    minArr = new int[size];
  }

  public void put(int value) {
    if (isFull()) {
      throw new RuntimeException("practice.stack.Stack is full");
    }
    arr[top] = value;
    int min = isEmpty() ? value : (value <= minArr[top - 1] ? value : minArr[top - 1]);
    minArr[top] = min;
    top++;
  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty");
    }
    return arr[--top];
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty");
    }
    return arr[top - 1];
  }

  public int getMin() {
    if (isEmpty()) {
      throw new RuntimeException("practice.stack.Stack is empty");
    }
    return minArr[top - 1];
  }

  public boolean isFull() {
    return top == arr.length;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public void printContent() {
    System.out.println(Arrays.toString(arr) + "," + Arrays.toString(minArr) + " top:" + top);
  }
}
