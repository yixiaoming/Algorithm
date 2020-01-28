package leetcode;/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            n --;
            sb.insert(0, (char)('A' + (n%26)));
            n /= 26;
        }
        return sb.toString();
    }
}
// @lc code=end
