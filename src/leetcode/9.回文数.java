package leetcode;/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        if ( x % 10 == 0 && x != 0) return false;
        int reverse = 0;
        while ( reverse < x ) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse==x || reverse/10==x;
    }
}
// @lc code=end

