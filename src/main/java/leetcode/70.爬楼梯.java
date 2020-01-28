package leetcode;/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        long num1 = 1;
        long num2 = 2;
        while (n > 2) {
            long temp = num1 + num2;
            num1 = num2;
            num2 = temp;
            n--;
        }
        return (int) num2;
    }
}
// @lc code=end
