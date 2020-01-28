package leetcode;/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */


import java.util.LinkedList;

// @lc code=start
class MinStack {

    private LinkedList<Integer> mStack;
    private LinkedList<Integer> mMinStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mStack = new LinkedList<>();
        mMinStack = new LinkedList<>();
    }

    public void push(int x) {
        mStack.push(x);
        if (mMinStack.size() == 0) {
            mMinStack.push(x);
            return;
        }
        mMinStack.push(Math.min(mMinStack.getFirst(), x));
    }

    public void pop() {
        if (mStack.size() == 0) return;
        mStack.pop();
        mMinStack.pop();
    }

    public int top() {
        return mStack.getFirst();
    }

    public int getMin() {
        return mMinStack.getFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

