package leetcode;/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length - 1;
        while (L < R) {
            int sum = numbers[L] + numbers[R];
            if (target == sum) {
                break;
            } else if (sum < target) {
                L++;
            } else {
                R--;
            }
        }
        return new int[] { L + 1, R + 1 };
    }
}
// @lc code=end
