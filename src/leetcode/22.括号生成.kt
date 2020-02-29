/*
 * @lc app=leetcode.cn id=22 lang=kotlin
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var result = arrayListOf<String>()

        fun process(leftReset: Int, rightReset: Int, str: String) {
            if (leftReset > rightReset) return

            if (str.length == n * 2) {
                result.add(str)
                return
            }
            if (leftReset > 0) {
                process(leftReset - 1, rightReset, "$str(")
            }
            if (rightReset > 0) {
                process(leftReset, rightReset - 1, "$str)")
            }
        }
        process(n, n, "")
        return result
    }
}
// @lc code=end

