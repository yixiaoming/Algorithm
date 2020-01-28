package leetcode;/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int lastWordLen = 0;
        int R = s.length() - 1;
        while (R >= 0 && s.charAt(R) == ' ') R--;
        while (R >= 0 && s.charAt(R) != ' ') {
            R--;
            lastWordLen++;
        }
        return lastWordLen;
    }
}
// @lc code=end

