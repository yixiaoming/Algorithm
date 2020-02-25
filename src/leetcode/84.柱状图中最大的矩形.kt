/*
 * @lc app=leetcode.cn id=84 lang=kotlin
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
import java.util.*
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        var stack = Stack<Int>().apply {
            push(-1)
        }
        for (i in 0 until heights.size) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1))
            }
            stack.push(i)
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.size - stack.peek() - 1))
        }
        return maxArea
    }
}
// @lc code=end

