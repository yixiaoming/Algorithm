/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            if(num > maxNum) maxNum = num;
            sum += num;
        }
        return nums.length*(nums.length+1)/2 - sum;
    }
}
// @lc code=end

