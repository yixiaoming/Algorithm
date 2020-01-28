package leetcode;/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int fiveNum = 0;
        while (n > 0){
            fiveNum += n/5;
            n /= 5;
        }
        return fiveNum;
    }
}
// @lc code=end
