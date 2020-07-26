/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for(int i=1; i<nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int temp = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i] = result[i] * temp;
            temp *= nums[i];
        }
        return result;
    }
}
// @lc code=end

