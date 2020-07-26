import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int card1 = nums[0], card2 = nums[0];
        int count1 = 0, count2 = 0;
        for(int num : nums){
            if(card1 == num) {
                count1++;
                continue;
            }
            if(card2 == num){
                count2++;
                continue;
            }
            if(count1 == 0){
                card1 = num;
                count1++;
                continue;
            }
            if(count2 == 0){
                card2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for(int num:nums){
            if(card1 == num) count1++;
            else if(card2 == num) count2++;
        }
        if(count1 > nums.length / 3) res.add(card1);
        if(count2 > nums.length / 3) res.add(card2);
        return res;
    }
}
// @lc code=end
