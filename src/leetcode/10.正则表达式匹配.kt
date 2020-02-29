/*
 * @lc app=leetcode.cn id=10 lang=kotlin
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) return s.isEmpty()
        var firstMatch = ( !s.isEmpty() && (s[0] == p[0] || p[0] == '.'))
        if (p.length >= 2 && p[1] == '*') {
            return (isMatch(s, p.substring(2))) || (firstMatch && isMatch(s.substring(1), p))
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1))
        }
    }
}
// @lc code=end

