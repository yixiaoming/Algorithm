/*
 * @lc app=leetcode.cn id=85 lang=kotlin
 *
 * [85] 最大矩形
 */

// @lc code=start
import java.util.Stack;
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

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        var maxArea = 0
        if (matrix.size == 0) return maxArea
        var arr = IntArray(matrix[0].size)
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                arr[j] = if (matrix[i][j] == '1') arr[j] + 1 else 0
            }
            maxArea = Math.max(largestRectangleArea(arr), maxArea)
        }
        return maxArea
    }
}
// @lc code=end

