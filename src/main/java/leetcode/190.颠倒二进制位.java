package leetcode;/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int count = 32;
        while (count > 0) {
            res = res << 1;
            res |= (n & 1);
            n = n >> 1;
            count--;
        }
        return res;
    }
}
// @lc code=end
