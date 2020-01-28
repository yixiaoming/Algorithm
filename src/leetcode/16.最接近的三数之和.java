package leetcode;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length; i++){
            int L = i+1;
            int R = nums.length-1;

            while(L<R){
                int temp = nums[i] + nums[L] + nums[R];
                if (Math.abs(temp - target) < Math.abs(result - target)) {
                    result = temp;
                }
                if ( temp < target ){   
                    L++;
                } else if(temp > target) {
                    R--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
// @lc code=end

