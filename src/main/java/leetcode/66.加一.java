package leetcode;/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int R = digits.length - 1;
        while (R >= 0 && digits[R] + 1 >= 10) {
            digits[R] = 0;
            if (R == 0) {
                int[] digitsExtend = new int[digits.length + 1];
                digitsExtend[0] = 1;
                System.arraycopy(digits, 0, digitsExtend, 1, digitsExtend.length - 1);
                return digitsExtend;
            }
            R--;
        }
        digits[R]++;
        return digits;
    }
}
// @lc code=end

