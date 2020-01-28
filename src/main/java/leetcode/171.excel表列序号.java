package leetcode;/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = num * 26 + c - 'A' + 1;
        }
        return num;
    }
}
// @lc code=end
