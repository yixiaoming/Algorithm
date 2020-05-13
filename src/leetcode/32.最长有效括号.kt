/*
 * @lc app=leetcode.cn id=32 lang=kotlin
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    fun longestValidParentheses(s: String): Int {
        if (s.isEmpty()) return 0
        var leftCount = 0
        var rightCount = 0
        var maxLen = 0
        for ((index, value) in s.withIndex()) {
            if (value == '(') {
                leftCount++
            } else if (value == ')') {
                rightCount++
            }
            if (rightCount > leftCount) {
                break
            }
            if (leftCount == rightCount)
                maxLen = leftCount * 2
        }
        return Math.max(maxLen, longestValidParentheses(s.substring(1)))
    }
}
// @lc code=end

