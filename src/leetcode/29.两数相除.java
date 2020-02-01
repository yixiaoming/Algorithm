/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (19.08%)
 * Likes:    258
 * Dislikes: 0
 * Total Accepted:    32.4K
 * Total Submissions: 169.6K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -dividend;
        }
        long a = dividend;
        long b = divisor;
        int plus = (a > 0 && b < 0) || (a < 0) && (b > 0) ? -1 : 1;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        return plus * div(a, b);
    }

    public int div(long a, long b) {
        int count = 1;
        if (a < b) return 0;
        if (a == b || a < (b << 1)) return 1;
        long temp = b;
        while (a > temp << 1) {
            count += count;
            temp <<= 1;
        }
        return count + div(a - temp, b);
    }
}
// @lc code=end
