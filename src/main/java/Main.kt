import kotlin.math.max

class Solution1 {
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
        return max(maxLen, longestValidParentheses(s.substring(1)))
    }
}

fun main() {
    val solution = Solution1()
    val result = solution.longestValidParentheses(")()())")
    println(result)
}
