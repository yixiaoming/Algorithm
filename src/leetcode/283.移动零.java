/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNot0Num = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){continue;}
            swap(nums, lastNot0Num, i);
            lastNot0Num++;
        }
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

