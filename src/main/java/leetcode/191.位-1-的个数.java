package leetcode;/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 32;
        int oneCount = 0;
        while (count-- > 0) {
            if ((n & 1) == 1) {
                oneCount++;
            }
            n >>= 1;
        }
        return oneCount;
    }
}
// @lc code=end
