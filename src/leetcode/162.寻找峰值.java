/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }
        return nums.length - 1;
    }
}
// @lc code=end

