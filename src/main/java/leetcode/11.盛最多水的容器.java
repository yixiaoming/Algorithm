package leetcode;/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int max = Integer.MIN_VALUE;

        while(L<R){
            max = Math.max(max, (R-L)*Math.min(height[L], height[R]));
            if(height[L] < height[R]){
                L++;
            }else{
                R--;
            }
        }
        return max;
    }
}
// @lc code=end
