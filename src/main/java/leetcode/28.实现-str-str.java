package leetcode;/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int match = 0;
                for (int j = 0; j < needle.length(); j++) {
                    if (i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                        match++;
                    }
                }
                if (match == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

