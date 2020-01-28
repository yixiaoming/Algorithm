package leetcode;/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int L = 0;
        int R = 0;

        while (R < nums.length) {
            while (L < nums.length) {
                if (nums[L] == val) {
                    break;
                }
                L++;
            }
            R = L+1;
            while (R < nums.length) {
                if (nums[R] != val) {
                    int temp = nums[L];
                    nums[L] = nums[R];
                    nums[R] = temp;
                    break;
                }
                R++;
            }
        }
        return L;
    }
}
// @lc code=end

