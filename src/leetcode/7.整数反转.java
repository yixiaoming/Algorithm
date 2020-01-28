package leetcode;/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int rX = 0;
        while(x!=0){
            int pop = x%10;
            x /= 10;
            if(rX > Integer.MAX_VALUE / 10 || (rX == Integer.MAX_VALUE/10 && x > 7)) return 0;
            if(rX < Integer.MIN_VALUE / 10 || (rX == Integer.MIN_VALUE/10 && x < -8)) return 0;
            rX = rX*10+pop;
        }
        return rX;
    }
}
// @lc code=end

