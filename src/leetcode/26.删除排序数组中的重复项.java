package leetcode;/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int temp = nums[0];
        int index = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != temp){
                nums[index++] = nums[i];
                temp = nums[i];
            }
        }
        return index;
    }
}
// @lc code=end

