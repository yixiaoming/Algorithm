import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int pos = 0;
        Stack<Integer> stack = new Stack();
        int result = 0;
        while(pos < height.length){
            while(!stack.isEmpty() && height[pos] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int minHeight = Math.min(height[stack.peek()], height[pos]);
                int width = pos - stack.peek() - 1;
                result += ((minHeight - h) * width);
            }
            stack.push(pos);
            pos++;
        }
        return result;
    }
}
// @lc code=end

