package leetcode;/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();

        int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] alphas = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int index = 0;
        while (num > 0) {
            while (num >= nums[index]) {
                sb.append(alphas[index]);
                num -= nums[index];
            }
            index++;
        }

        return sb.toString();
    }
}
// @lc code=end
