/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int sum = 0;
        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
    
        while(end < n){
            sum += nums[end];
            while(sum >= s){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end
