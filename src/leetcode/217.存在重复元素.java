import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
// @lc code=end

