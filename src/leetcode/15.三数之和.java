package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int L = i+1;
            int R = nums.length-1;
            if(nums[i]>0){
                break;
            }
            if (i>0 && nums[i] == nums[i-1]) continue;
            while(L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if( sum == 0){
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L<R && nums[L] == nums[L+1])
                        L++;
                    while(L<R && nums[R] == nums[R-1])
                        R--;
                    L++;
                } else if( sum < 0 ){
                    L++;
                } else if( sum > 0){
                    R--;
                }
            }
            
        }
        return result;
    }
}
// @lc code=end

